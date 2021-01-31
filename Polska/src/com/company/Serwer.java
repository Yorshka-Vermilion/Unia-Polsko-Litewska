package com.company;

import com.produkty.ObslugaProduktow;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;

public class Serwer {
    private ServerSocket serverSocket;
    private ArrayList<Thread> watki;
    private int aktualnaIloscWatkow;

    Serwer() {
        try {
            serverSocket = new ServerSocket(4999);
            this.aktualnaIloscWatkow = 0;
            this.watki = new ArrayList<Thread>();
            start();
        } catch (IOException e) {
            System.err.println("Blad podczas uruchamiania serwera");
        }

    }

    void start(){
        try {
            ObslugaProduktow.wczytaj();
            //ObslugaProduktow.WypiszListe(); // OK
            //ObslugaProduktow.PosortujListeCena(false); // OK

            System.out.println(KOLORY.FIOLETOWY.kolor + "Serwer czeka na klienta..." + KOLORY.RESET.kolor);
            czekaj();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    boolean czekaj(){
        while(true) { // Czeka na klientow, trzeba ogarnac jakies wychodzenie, moze drugi watek poprostu w serwerze (jeden czeka na klienta czyli to nizej, drugi czeka na wprowadzenie komendy stop, potem wali interrupta na ten watek nizej i elo)
            try {
                this.watki.add(new Thread(new SerwerThread(serverSocket.accept(),aktualnaIloscWatkow))); // accept to funkcja blokujaca wie bedzie czekac az klient nie przyjdzie
                this.watki.get(aktualnaIloscWatkow).start();
                System.out.println(KOLORY.NIEBIESKI.kolor + "<" + this.aktualnaIloscWatkow + ">Podlaczono klienta" + KOLORY.RESET.kolor);
                this.aktualnaIloscWatkow++;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}

package com.company;

import com.produkty.ObslugaProduktow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Serwer {
    ServerSocket serverSocket;
    boolean dziala = true;
    ArrayList<Thread> watki;
    int aktualnaIloscWatkow;

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
            //ObslugaProduktow.WypiszListe();
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

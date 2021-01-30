package com.company;

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
    volatile LinkedList<Produkt> listaObiektow; // To trzeba ogarnac
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
                this.watki.add(new Thread(new SerwerThread(serverSocket.accept()))); // accept to funkcja blokujaca wie bedzie czekac az klient nie przyjdzie
                this.watki.get(aktualnaIloscWatkow).start();
                this.aktualnaIloscWatkow++;
                System.out.println(KOLORY.NIEBIESKI.kolor + "Podlaczono klienta" + KOLORY.RESET.kolor);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}

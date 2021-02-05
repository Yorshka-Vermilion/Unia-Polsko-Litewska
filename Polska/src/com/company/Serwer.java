package com.company;

import com.produkty.ObslugaProduktow;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Glowna klasa serwera
 */
public class Serwer {
    /**
     * "Socket" servera
     */
    private ServerSocket serverSocket;
    /**
     * Tablica watkow
     */
    private ArrayList<SerwerThread> watki;
    /**
     * Zmienna przechowujaca liczbe uzytych watkow
     */
    private int aktualnaIloscWatkow;

    /**
     * Scanner sluzacy do wczytywania komend wprowadzanych przez uzytkownika
     */
    private Scanner scan;

    /**
     * Komenda ktora zeskanowal scanner
     */
    private String komenda;

    /**
     * Konstruktor domyslny serwera, tworzy nowy socket servera, tablice watkow oraz startuje serwer
     */
    Serwer() {
        try {
            serverSocket = new ServerSocket(4999);
            this.aktualnaIloscWatkow = 0;
            this.watki = new ArrayList<SerwerThread>();
            this.scan = new Scanner(System.in);
            start();
            System.out.println(KOLORY.CYJAN.kolor + "Serwer zakonczyl prace." + KOLORY.RESET.kolor);
        } catch (IOException e) {
            System.err.println("Blad podczas uruchamiania serwera");
        }

    }

    /**
     * Funkcja startujaca serwer
     */
    private void start(){
        try {
            ObslugaProduktow.wczytaj(); // Wczytanie plikow do statycznej zmiennej w klasie "ObslugaProduktow"

            System.out.println(KOLORY.FIOLETOWY.kolor + "Serwer czeka na klienta..." + KOLORY.RESET.kolor);
            Thread czekajacy = new Thread(() -> { // Watek sluzy do czekania na klienta az ten nie pojawi sie. Kiedy sie pojawi, przypisuje mu nowy watek, inkrementuje zmienna aktualnaIloscWatkow oraz czeka na nastepnego klienta.
                while(!Thread.interrupted()) {
                    try {
                        this.watki.add(new SerwerThread(serverSocket.accept(),aktualnaIloscWatkow)); // accept to funkcja blokujaca wie bedzie czekac az klient nie przyjdzie, przy przerwaniu wyrzuci wyjatek ale mozna go zignorowac
                        this.watki.get(aktualnaIloscWatkow).start();
                        System.out.println(KOLORY.NIEBIESKI.kolor + "<" + this.aktualnaIloscWatkow + ">Podlaczono klienta" + KOLORY.RESET.kolor);
                        this.aktualnaIloscWatkow++;
                    } catch (IOException e) {
                        System.out.println(KOLORY.BIALY.kolor + "ZAMKNIETO WATEK CZEKAJACY" + KOLORY.RESET.kolor);
                    }
                }
            });
            czekajacy.start();

            while(true){
                if(scan.nextLine().equals("STOP")){
                    czekajacy.interrupt();
                    czekajacy.join(1000); // Czeka max 1 sekunde
                    break;
                }
            }

            zatrzymajKlientow();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("ZAMKNIECIE SERWERA NIE POWIODLO SIE.");
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.err.println("PROBLEM PRZY ZAMKNIECIU WATKU CZEKAJACEGO NA KLIENTOW");
        }
    }

    /**
     * Funkcja zatrzymuje wszystkich obecnych jeszcze klientow
     */
    private void zatrzymajKlientow(){
        for(int i=0;i<aktualnaIloscWatkow;i++){
            if(watki.get(i).isAlive()){
                watki.get(i).zatrzymaj();
            }
        }
    }

}

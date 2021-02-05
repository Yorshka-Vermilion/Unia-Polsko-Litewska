package com.company;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

/**
 * Klasa klienta
 */
public class Klient {
    /**
     * Socket uzywany do polaczenia miedzy klientem a serwerem
     */
    private Socket socket;
    /**
     * Konwertuje wprowaczony przez uzytkownika, lub podany w argumencie ciag znakow na ciag bajtow w celu przeslania ich przez socket do serwera
     */
    private PrintStream ps;
    /**
     * Wiadomosc ktora wysyla klient
     */
    private String wiadomosc;
    /**
     * Odpowiedz ktora otrzymuje klient
     */
    private String odpowiedz;
    /**
     * Most pomiedzy ciagami bajtowymi a siagami znakow, czyta bajty i dekoduje je w znaki, uzywany razem z bufferem do odczytu tekstu przeslanego przez serwer przez socket
     */
    private InputStreamReader ir;
    /**
     * Buffor sluzacy do czytania tekstu z ciagu znakow w taki sposob aby zapewnic efektywne czytanie znakow, tablic i linii
     */
    private BufferedReader br;
    /**
     * Scanner sluzacy do wczytywania komend wprowadzanych przez uzytkownika
     */
    private Scanner scanner;

    /**
     * Konstruktor klienta, tworzy nowy socket, buffory i scanner, oraz startuje klienta
     */
    Klient(){
        try {
            socket = new Socket("localhost", 4999);
            ps = new PrintStream(socket.getOutputStream());
            scanner = new Scanner(System.in);
            wiadomosc = "";
            ir = new InputStreamReader(socket.getInputStream());
            br = new BufferedReader(ir);
            start();
        } catch (IOException e) {
            System.err.println("Blad podczas laczenia sie z serwerem");
        }
    }

    /**
     * Funkcja operujaca funkcjonalnoscami klienta, czeka na wprowadzenie przez klienta komendy, przesyla ją na serwer i wyswietla odpowiedz
     */
    private void start(){
        try {
            System.out.println(KOLORY.NIEBIESKI.kolor + "Polaczono z serwerem" + KOLORY.RESET.kolor);
            while(!(wiadomosc.trim().equals("STOP"))){ // com.company.Klient konczy prace na komende "STOP"
                    wiadomosc = scanner.nextLine();
                    ps.println(wiadomosc);

                    //Odpowiedz serwera

                    while((odpowiedz = br.readLine()) != null) {
                        if(odpowiedz.equals("KNW"))break;
                        System.out.println(odpowiedz);
                    }


                }
            br.close();
            ir.close();
            scanner.close();
            ps.close();
            socket.close();
        } catch(SocketException e){
            System.out.println(KOLORY.CZERWONY.kolor + "SERWER PRZERWAL POLACZENIE" + KOLORY.RESET.kolor);
        } catch (IOException e) {
            System.out.println(KOLORY.CZERWONY.kolor + "POLACZENIE Z SERWEREM ZOSTALO PRZERWANE" + KOLORY.RESET.kolor);
        }
    }
}

package com.company;

import com.produkty.ObslugaProduktow;
import com.produkty.Produkt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.LinkedList;

/**
 * Klasa watkow serwera obslugujacych klientow
 */
public class SerwerThread extends Thread{

    /**
     * Most pomiedzy ciagami bajtowymi a siagami znakow, czyta bajty i dekoduje je w znaki, uzywany razem z bufferem do odczytu tekstu przeslanego przez klienta przez socket
     */
    private InputStreamReader isr;
    /**
     * Buffor sluzacy do czytania tekstu z ciagu znakow w taki sposob aby zapewnic efektywne czytanie znakow, tablic i linii
     */
    private BufferedReader br;

    /**
     * Wiadomosc ktora odbiera serwer
     */
    private String wiadomosc;
    /**
     * Konwertuje wprowaczony przez uzytkownika, lub podany w argumencie ciag znakow na ciag bajtow w celu przeslania ich przez socket do klienta
     */
    private PrintStream ps;
    /**
     * Typ logiczny przechowujaca informacje czy watek powinien zostac zamkniety
     */
    private boolean exit = false;
    /**
     * Numer tego watku
     */
    private int nrWatku;

    /**
     * Socket uzywany do polaczenia miedzy tym watkiem a klientem
     */
    private Socket socket;

    /**
     * Konstruktor watku serwera
     * @param socket Socket przekazany przez serwer w celu komunikacji na nim tego watku i jednego klienta
     * @param nrWatku numer tego watku
     */
    SerwerThread(Socket socket, int nrWatku){
        this.nrWatku = nrWatku;
        try {
            this.socket=socket;
            isr = new InputStreamReader(socket.getInputStream());
            br = new BufferedReader(isr);
            ps = new PrintStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * przekazuje wygenerowana przez watek liste do klienta
     * @param lista Lista do przekazania
     */
    private void przekazListe(LinkedList<Produkt> lista){
        for (int i = 0; i < lista.size(); i++) {
            ps.println(lista.get(i).toString());
        }
    }

    /**
     * Funkcja opisujaca dzialanie watku
     */
    public void run() {
        try {
            while ((wiadomosc = br.readLine()) != null && !exit) { // Czekanie na klienta
                System.out.println(KOLORY.ZOLTY.kolor + "<" + this.nrWatku + ">" + KOLORY.RESET.kolor + "Klient: " + wiadomosc);
                String msg[] = wiadomosc.split(" ");
                if (wiadomosc.equals("STOP")) {
                    ps.println(KOLORY.BIALY.kolor + "Klient zakonczyl komunikacjie" + KOLORY.RESET.kolor);
                    exit = true;
                    break;
                } else if (msg[0].equals("WYPISZ")) {
                    ps.println(KOLORY.ZIELONY.kolor + "WYPISYWANIE LISTY PRODUKTOW" + KOLORY.RESET.kolor);
                    if (msg.length > 1 && msg[1].equals("KATEGORIA")) {
                        LinkedList<Produkt> tmp = ObslugaProduktow.PobierzListeProduktowKategoria(msg[2]);
                        System.out.println(msg[2]);
                        if (tmp == null || tmp.size() == 0) {
                            ps.println(KOLORY.CZERWONY.kolor + "PODAJ POPRAWNA KATEGORIE!" + KOLORY.RESET.kolor);
                        } else {
                            przekazListe(tmp);
                        }
                    } else if (msg.length > 3 && msg[1].equals("SORTUJ")) {
                        if (msg[2].equals("CENA")) {
                            if (msg[3].equals("ROSNACO")) {
                                LinkedList<Produkt> tmp = ObslugaProduktow.PosortujListeCena(true);
                                przekazListe(tmp);
                            } else if (msg[3].equals("MALEJACO")) {
                                LinkedList<Produkt> tmp = ObslugaProduktow.PosortujListeCena(false);
                                przekazListe(tmp);
                            } else {
                                ps.println(KOLORY.CZERWONY.kolor + "NIE ROZPOZNANO KIERUNKU SORTOWANIA" + KOLORY.RESET.kolor);
                            }
                        } else {
                            ps.println(KOLORY.CZERWONY.kolor + "NIE ROZPOZNANO KOMENDY" + KOLORY.RESET.kolor);
                        }

                    } else {
                        przekazListe(ObslugaProduktow.PobierzListeProduktow());
                    }
                } else {
                    ps.println(KOLORY.CZERWONY.kolor + "NIE ROZPOSNANO KOMENDY" + KOLORY.RESET.kolor);
                }
                ps.println("KNW");
            }

        } catch (SocketException e){
            System.out.println(KOLORY.CZERWONY.kolor + "<" + this.nrWatku + ">" + KOLORY.RESET.kolor + "Praca tego watku zostala przerwana przez serwer");
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            System.out.println(KOLORY.CZERWONY.kolor + "<" + this.nrWatku + ">" + KOLORY.RESET.kolor + "Koniec komunikacji na tym watku");
        }
    }

    /**
     * Funkcja sluzaca do prawidlowego zatrzymania watku (zamkniecie bufforow i socketu)
     */
    public void zatrzymaj(){
        ps.close();
        try {
            br.close();
            isr.close();
            this.socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package com.company;

import com.produkty.ObslugaProduktow;
import com.produkty.Produkt;

import java.awt.desktop.SystemSleepEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.LinkedList;

public class SerwerThread implements Runnable{

    private InputStreamReader isr;
    private BufferedReader br;
    private String wiadomosc, odpowiedz;
    private PrintStream ps;
    private Socket socket;
    private boolean exit = false;
    private int nrWatku;


    SerwerThread(Socket socket, int nrWatku){
        this.socket = socket;
        this.nrWatku = nrWatku;
        try {
            isr = new InputStreamReader(socket.getInputStream());
            br = new BufferedReader(isr);
            ps = new PrintStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void przekazListe(LinkedList<Produkt> lista){
        for (int i = 0; i < lista.size(); i++) {
            ps.println(lista.get(i).toString());
        }
    }

    public void run(){

        try {
            while((wiadomosc = br.readLine())!=null && !exit) { // Czekanie na klienta
                System.out.println(KOLORY.ZOLTY.kolor + "<"+this.nrWatku+">" + KOLORY.RESET.kolor + "Klient: " + wiadomosc);
                String msg[] = wiadomosc.split(" ");
                if (wiadomosc.equals("STOP")) {
                    ps.println(KOLORY.BIALY.kolor + "Klient zakonczyl komunikacjie" + KOLORY.RESET.kolor);
                    exit = true;
                    break;
                }else if(msg[0].equals("WYPISZ")){
                    ps.println(KOLORY.ZIELONY.kolor + "WYPISYWANIE LISTY PRODUKTOW" + KOLORY.RESET.kolor);
                    if(msg.length > 1 && msg[1].equals("KATEGORIA")){
                        LinkedList<Produkt> tmp = ObslugaProduktow.PobierzListeProduktowKategoria(msg[2]);
                        System.out.println(msg[2]);
                        if(tmp==null || tmp.size() == 0){
                            ps.println(KOLORY.CZERWONY.kolor + "PODAJ POPRAWNA KATEGORIE!" + KOLORY.RESET.kolor);
                        }else {
                            przekazListe(tmp);
                        }
                    }else if(msg.length > 3 && msg[1].equals("SORTUJ")){
                        if(msg[2].equals("CENA")){
                            if(msg[3].equals("ROSNACO")){
                                LinkedList<Produkt> tmp = ObslugaProduktow.PosortujListeCena(true);
                                przekazListe(tmp);
                            }else if(msg[3].equals("MALEJACO")){
                                LinkedList<Produkt> tmp = ObslugaProduktow.PosortujListeCena(false);
                                przekazListe(tmp);
                            }else{
                                ps.println(KOLORY.CZERWONY.kolor + "NIE ROZPOZNANO KIERUNKU SORTOWANIA" + KOLORY.RESET.kolor);
                            }
                        }else{
                            ps.println(KOLORY.CZERWONY.kolor + "NIE ROZPOZNANO KOMENDY" + KOLORY.RESET.kolor);
                        }

                    }else {
                        przekazListe(ObslugaProduktow.PobierzListeProduktow());
                    }
                }else{
                    ps.println(KOLORY.CZERWONY.kolor + "NIE ROZPOSNANO KOMENDY" + KOLORY.RESET.kolor);
                }
                ps.println("KNW");
            }

         } catch (IOException e) {

         }finally {
            System.out.println(KOLORY.CZERWONY.kolor + "<"+this.nrWatku+">" + KOLORY.RESET.kolor + "Koniec komunikacji na tym watku");
            ps.close();
            try {
                br.close();
                isr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
         }
    } // Trzeba obsluzyc interrupta (jak serwer sie zamknie) to zeby watki wyslaly jeszcze info do klienta ze serwer zamknal polaczenie
}

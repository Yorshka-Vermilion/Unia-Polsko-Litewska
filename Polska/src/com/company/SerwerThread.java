package com.company;

import com.produkty.ObslugaProduktow;

import java.awt.desktop.SystemSleepEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;

public class SerwerThread implements Runnable{

    InputStreamReader isr;
    BufferedReader br;
    String wiadomosc, odpowiedz;
    PrintStream ps;
    Socket socket;
    boolean exit = false;
    int nrWatku;


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

    public void run(){

        try {
            while((wiadomosc = br.readLine())!=null && !exit) { // Czekanie na klienta
                System.out.println(KOLORY.ZOLTY.kolor + "<"+this.nrWatku+">" + KOLORY.RESET.kolor + "Klient: " + wiadomosc);
                if (wiadomosc.equals("STOP")) {
                    ps.println(KOLORY.BIALY.kolor + "Klient zakonczyl komunikacjie" + KOLORY.RESET.kolor);
                    exit = true;
                    break;
                }else if(wiadomosc.equals("WYPISZ")){
                    ps.println(KOLORY.ZIELONY.kolor + "WYPISYWANIE LISTY PRODUKTOW" + KOLORY.RESET.kolor);
                    for(int i=0;i< ObslugaProduktow.getSize();i++){
                        ps.println(ObslugaProduktow.getProduktIndex(i).toString());
                    }
                }
                ps.println("KNW");
            }
            System.out.println(KOLORY.CZERWONY.kolor + "<"+this.nrWatku+">" + KOLORY.RESET.kolor + " :Koniec komunikacji na tym watku");
            ps.close();
            br.close();
            isr.close();
         } catch (IOException e) {
            e.printStackTrace();
        }
    } // Trzeba obsluzyc interrupta (jak serwer sie zamknie) to zeby watki wyslaly jeszcze info do klienta ze serwer zamknal polaczenie
}

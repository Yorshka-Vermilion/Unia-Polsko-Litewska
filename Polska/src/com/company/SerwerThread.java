package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;

public class SerwerThread implements Runnable{

    volatile LinkedList<String> lista;
    InputStreamReader isr;
    BufferedReader br;
    String wiadomosc, odpowiedz;
    PrintStream ps;
    Socket socket;



    SerwerThread(Socket socket){
        this.socket = socket;
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
            while((wiadomosc = br.readLine())!=null) { // Czekanie na klienta
                System.out.println("Klient: " + wiadomosc);
                if (wiadomosc.equals("STOP")) {
                    ps.println("Klient zakonczyl komunikacjie");
                    break;
                }
            }
            ps.close();
            br.close();
            isr.close();
         } catch (IOException e) {
            e.printStackTrace();
        }
    } // Trzeba obsluzyc interrupta (jak serwer sie zamknie) to zeby watki wyslaly jeszcze info do klienta ze serwer zamknal polaczenie
}

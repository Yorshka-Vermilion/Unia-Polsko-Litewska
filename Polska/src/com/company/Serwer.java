package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Serwer {
    ServerSocket serverSocket;
    Socket socket;
    InputStreamReader isr;
    BufferedReader br;
    boolean dziala = true;
    String wiadomosc, odpowiedz;
    PrintStream ps;


    Serwer() {
        try {
            serverSocket = new ServerSocket(4999);
            System.out.println(KOLORY.FIOLETOWY.kolor + "Serwer czeka na klienta..." + KOLORY.RESET.kolor);
            socket = serverSocket.accept();
            System.out.println(KOLORY.NIEBIESKI.kolor + "Podlaczono klienta" + KOLORY.RESET.kolor);
            start();
        } catch (IOException e) {
            System.err.println("Blad podczas uruchamiania serwera");
        }

    }

    void start(){
        try {
            isr = new InputStreamReader(socket.getInputStream());
            br = new BufferedReader(isr);
            ps = new PrintStream(socket.getOutputStream());

            while((wiadomosc = br.readLine())!=null){
                System.out.println("Klient: " + wiadomosc);
                    if(wiadomosc.equals("STOP")){
                        ps.println("Klient zakonczyl komunikacjie");
                        break;
                    }
            }
            ps.close();
            br.close();
            isr.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

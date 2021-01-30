package com.company;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Klient {
    Socket socket;
    PrintStream ps;
    String wiadomosc,odpowiedz;
    InputStreamReader ir;
    BufferedReader br;
    Scanner scanner;

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

    private void start(){
        try {
            System.out.println(KOLORY.NIEBIESKI.kolor + "Polaczono z serwerem" + KOLORY.RESET.kolor);
            while(!(wiadomosc.trim().equals("STOP"))){ // com.company.Klient konczy prace na komende "STOP"
                    wiadomosc = scanner.nextLine();
                    ps.println(wiadomosc);
                    //Odpowiedz serwera

                    //odpowiedz = br.readLine().trim();
                    //System.out.println("ODpowiedz serwera: " + odpowiedz);

                }
            br.close();
            ir.close();
            scanner.close();
            ps.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

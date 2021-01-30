package com.company;

import com.produkty.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class ObslugaPlikow {
    private static Scanner scan;
    public static LinkedList<Produkt> wczytaj(String sciezka){
        File plik = new File(sciezka);
        LinkedList<Produkt> produkty = new LinkedList<>();
        try {
            scan = new Scanner(plik);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while(scan.hasNextLine()){
            String[] tmp = scan.nextLine().split(",");
            if(tmp.length > 1) {
                produkty.add(WczytajProdukt(tmp));
            }
        }
        return produkty;
    };

    private static Produkt WczytajProdukt(String[] dane){
        float[] daneFloat = new float[8];
        for(int i=0;i<8;i++){
            daneFloat[i] = Float.parseFloat(dane[i+1]);
        }
        if(dane[0].equals("HDD") && dane.length == 14) {
            return new HDD(Integer.parseInt(dane[1]),
                    daneFloat, Boolean.parseBoolean(dane[10]), dane[11], dane[12], Integer.parseInt(dane[13]));
        }else if(dane[0].equals("DYSKIETKA") && dane.length == 14){
            return new Dyskietka(Integer.parseInt(dane[1]),
                    daneFloat, Boolean.parseBoolean(dane[10]), dane[11], dane[12], dane[13]);
        }else if(dane[0].equals("TASMA MAGNETYCZNA") && dane.length == 15){
            return new TasmaMagnetyczna(Integer.parseInt(dane[1]),
                    daneFloat, Boolean.parseBoolean(dane[10]), dane[11], dane[12], Integer.parseInt(dane[13]), Boolean.parseBoolean(dane[14]));
        }else if(dane[0].equals("PLYTA") && dane.length == 15){
            return new Plyta(Integer.parseInt(dane[1]),
                    daneFloat, Boolean.parseBoolean(dane[10]), dane[11], Integer.parseInt(dane[12]), dane[13], dane[14]);
        }else if(dane[0].equals("NAPED OPTYCZNY") && dane.length == 15){
            return new NapedOptyczny(Integer.parseInt(dane[1]),
                    daneFloat, Boolean.parseBoolean(dane[10]), dane[11], Integer.parseInt(dane[12]), dane[13], dane[14]);
        }else if(dane[0].equals("SSD") && dane.length == 16){
            return new SSD(Integer.parseInt(dane[1]),
                    daneFloat, Boolean.parseBoolean(dane[10]), dane[11], dane[12],dane[13],Integer.parseInt(dane[14]),dane[15]);
        }else if(dane[0].equals("RAM") && dane.length == 16){
            return new RAM(Integer.parseInt(dane[1]),
                    daneFloat, Boolean.parseBoolean(dane[10]), dane[11], dane[12],dane[13],Integer.parseInt(dane[14]),dane[15]);
        }else if(dane[0].equals("USB") && dane.length == 16){
            return new USB(Integer.parseInt(dane[1]),
                    daneFloat, Boolean.parseBoolean(dane[10]), dane[11], dane[12],dane[13],Integer.parseInt(dane[14]),dane[15]);
        }else if(dane[0].equals("KARTA PAMIECI") && dane.length == 17){
            return new KartaPamieci(Integer.parseInt(dane[1]),
                    daneFloat, Boolean.parseBoolean(dane[10]), dane[11], dane[12],dane[13],Integer.parseInt(dane[14]),dane[15],dane[16]);
        }
        else {
            System.err.println("BLAD W PLIKU TEKSTOWYM");
            return null;
        }
    }
}

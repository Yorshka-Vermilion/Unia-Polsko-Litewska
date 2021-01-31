package com.produkty;

import com.company.ObslugaPlikow;

import java.util.LinkedList;

public class ObslugaProduktow {
    private volatile static LinkedList<Produkt> lista = null;

    public static void wczytaj(){
        if(lista == null) {
            lista = new LinkedList<Produkt>();
            lista = ObslugaPlikow.wczytaj("C:\\Users\\Arc\\Desktop\\Polibuda\\UJK\\Unia-Polsko-Litewska\\Polska\\src\\com\\company\\plik.txt");
        }else{
            System.err.println("LISTA ZOSTALA JUZ ZALADOWANA!");
        }
    }

    public static synchronized ProduktCore PobierzProduktIndex(int i){
        if(i < lista.size()) return lista.get(i);
        else return null;
    }

    public static synchronized int getSize(){
        return lista.size();
    }

    public static synchronized Produkt getProduktIndex(int i){
        if(i < getSize())return lista.get(i);
        System.err.println("Wystapil blad podczas proby wziecia produktu z listy produktow: INDEX NIE ISTNIEJE");
        return null;
    }

    public static synchronized LinkedList<Produkt> PobierzListeProduktow(){
        return lista;
    }

    public static synchronized LinkedList<Produkt> PobierzListeProduktowKategoria(String kategoria){ //Pobiera liste produktow z okreslonej kategorii (optyczny,polprzewodnikowy,magnetyczny)
        LinkedList<Produkt> tmp = new LinkedList<Produkt>();
        for(int i=0;i<getSize();i++){
            if(lista.get(i).getKategoria().equals(kategoria))tmp.add(lista.get(i));
        }
        return tmp;
    }

    public static synchronized LinkedList<Produkt> PosortujListeCena(boolean rosnaca){ // Sortowanie po cenie
        float indeksy[][] = new float[getSize()][2];
        for(int i=0;i<getSize();i++){
            indeksy[i][0] = lista.get(i).getCena();
            indeksy[i][1] = i;
        }
        return Sortuj(indeksy,rosnaca);
    }

    private static LinkedList<Produkt> Sortuj(float indeksy[][],boolean rosnaca){
        LinkedList<Produkt> tmp = new LinkedList<Produkt>();

        for (int i = 0; i < indeksy.length; i++) {
            float minI = indeksy[i][1];
            float min = indeksy[i][0];
            int minId = i;
            for (int j = i+1; j < indeksy.length; j++) {
                if (indeksy[j][0] < min) {
                    min = indeksy[j][0];
                    minI = indeksy[j][1];
                    minId = j;
                }
            }
            // swapping
            float tmpIndex = indeksy[i][1];
            float tmpCena = indeksy[i][0];
            indeksy[i][0] = min;
            indeksy[i][1] = minI;
            indeksy[minId][0] = tmpCena;
            indeksy[minId][1] = tmpIndex;
        }
        if(rosnaca) {
            for (int i = 0; i < indeksy.length; i++) {
                tmp.add(lista.get((int) indeksy[i][1]));
            }
        }else{
            for (int i = 0; i < indeksy.length; i++) {
                tmp.add(lista.get((int) indeksy[indeksy.length-i-1][1]));
            }
        }

        return tmp;
    };

    public static void WypiszListe(){
        for(int i=0;i<lista.size();i++){
            if(lista.get(i)!=null) {
                System.out.println(lista.get(i).toString());
            }else System.err.println("Blad w wypisywaniu " + (i+1) + " elementu, Sprawdz plik z danymi w tej linijce");
        }
    }

}

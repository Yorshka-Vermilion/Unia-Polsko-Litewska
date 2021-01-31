package com.produkty;

import com.company.ObslugaPlikow;
import com.produkty.ProduktCore;

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

    public static synchronized LinkedList<Produkt> PobierzListeProduktowKategoria(String kategoria){
        return null;
    }

    public static synchronized void PosortujListe(){}//Jakies sortowanie

    public static void WypiszListe(){
        for(int i=0;i<lista.size();i++){
            if(lista.get(i)!=null) {
                System.out.println(lista.get(i).toString());
            }else System.err.println("Blad w wypisywaniu " + (i+1) + " elementu, Sprawdz plik z danymi w tej linijce");
        }
    }

}

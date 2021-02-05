package com.produkty;

/**
 * Klasa opisujaca plyte
 */
public class Plyta extends Optyczny {
    /**
     * Typ plyty (DVD,CD,BLU-RAY...)
     */
    private String typ;

    /**
     /**
     * Konstruktor
     * @param id id produktu
     * @param dane tablica z danymi liczbowymi produktu
     * @param dostepnosc dostepnosc produktu
     * @param producent producent produktu
     * @param predkosc_obrotowa predkosc obrotowa
     * @param rodzaj_lasera rodzaj lasera uzywanego do odczytu
     * @param typ typ plyty
     */
    public Plyta(int id, float dane[], boolean dostepnosc, String producent, int predkosc_obrotowa, String rodzaj_lasera, String typ){
        super(id,dane,dostepnosc,producent,predkosc_obrotowa,rodzaj_lasera);
        this.typ = typ;
    }

    @Override
    public String toString(){
        return "PLYTA " + super.toString() + " TYP: " + this.typ;
    }
}

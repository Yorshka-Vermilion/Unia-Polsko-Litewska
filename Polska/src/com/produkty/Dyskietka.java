package com.produkty;


/**
 * Klasa opisujaca dyskietki
 */
public class Dyskietka extends Magnetyczny {
    /**
     * Material z jakiego zostal wykonany krazek
     */
    private String material_krazka;

    /**
     * Konstruktor
     * @param id id produktu
     * @param dane tablica z danymi liczbowymi produktu
     * @param dostepnosc dostepnosc produktu
     * @param producent producent produktu
     * @param rodzaj_nosnika_danych rodzaj nosnika danych
     * @param material_krazka material krazka
     */
    public Dyskietka(int id, float dane[], boolean dostepnosc, String producent, String rodzaj_nosnika_danych, String material_krazka){
        super(id,dane,dostepnosc,producent,rodzaj_nosnika_danych);
        this.material_krazka = material_krazka;
    }

    @Override
    public String toString(){
        return "DYSKIETKA " + super.toString() + " MATERIAL KRAZKA: " + this.material_krazka;
    }

}

package com.produkty;

/**
 * Klasa opisujaca pamiec USB
 */
public class USB extends Polprzewodnikowy {
    /**
     * Interfejs (USB 3.0, USB 2.0...)
     */
    private String interfejs;

    /**
     * Konstruktor
     * @param id id produktu
     * @param dane tablica z danymi liczbowymi produktu
     * @param dostepnosc dostepnosc produktu
     * @param producent producent produktu
     * @param rodzaj_tranzystorow rodzaj tranzystorow
     * @param producent_tranzystorow producent tranzystorow
     * @param liczba_tranzystorow liczba tranzystorow
     * @param interfejs interfejs
     */
    public USB(int id, float dane[], boolean dostepnosc, String producent, String rodzaj_tranzystorow, String producent_tranzystorow, int liczba_tranzystorow, String interfejs){
        super(id,dane,dostepnosc,producent,rodzaj_tranzystorow,producent_tranzystorow,liczba_tranzystorow);
        this.interfejs=interfejs;
    }

    @Override
    public String toString(){
        return "PAMIEC USB " + super.toString() + " INTERFEJS: " + this.interfejs;
    }
}

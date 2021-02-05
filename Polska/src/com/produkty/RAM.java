package com.produkty;

/**
 * Klasa opisujaca pamiec RAM
 */
public class RAM extends Polprzewodnikowy {
    /**
     * Typ slotu (DDR3,DDR4...)
     */
    private String slot;

     /**
      * Konstruktor
      * @param id id produktu
      * @param dane tablica z danymi liczbowymi produktu
      * @param dostepnosc dostepnosc produktu
      * @param producent producent produktu
      * @param rodzaj_tranzystorow rodzaj tranzystorow
      * @param producent_tranzystorow producent tranzystorow
      * @param liczba_tranzystorow liczba tranzystorow
      * @param slot slot do ktorego wchodzi pamiec
      */
    public RAM(int id, float dane[], boolean dostepnosc, String producent, String rodzaj_tranzystorow, String producent_tranzystorow, int liczba_tranzystorow, String slot){
        super(id,dane,dostepnosc,producent,rodzaj_tranzystorow,producent_tranzystorow,liczba_tranzystorow);
        this.slot=slot;
    }

    @Override
    public String toString(){
        return "PAMIEC RAM " + super.toString() + " SLOT: " + this.slot;
    }
}

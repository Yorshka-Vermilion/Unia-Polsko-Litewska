package com.produkty;

/**
 * Klasa opisujaca karty pamieci
 */
public class KartaPamieci extends Polprzewodnikowy {
    /**
     * Typ karty pamieci (sd,microsd...)
     */
    private String typ;
    /**
     * Przeznaczenie karty (telefon,aprat...)
     */
    private String przeznaczenie;

    /**
     /**
     * Konstruktor
     * @param id id produktu
     * @param dane tablica z danymi liczbowymi produktu
     * @param dostepnosc dostepnosc produktu
     * @param producent producent produktu
     * @param rodzaj_tranzystorow rodzaj tranzystorow
     * @param producent_tranzystorow producent tranzystorow
     * @param liczba_tranzystorow liczba tranzystorow
     * @param typ typ karty pamieci
     * @param przeznaczenie przeznaczenie karty pamieci
     */
    public KartaPamieci(int id, float dane[], boolean dostepnosc, String producent, String rodzaj_tranzystorow, String producent_tranzystorow, int liczba_tranzystorow, String typ, String przeznaczenie){
        super(id,dane,dostepnosc,producent,rodzaj_tranzystorow,producent_tranzystorow,liczba_tranzystorow);
        this.typ=typ;
        this.przeznaczenie=przeznaczenie;
    }

    @Override
    public String toString(){
        return "KARTA PAMIECI " + super.toString() + " TYP: " + this.typ + " PRZEZNACZENIE: " + this.przeznaczenie;
    }
}

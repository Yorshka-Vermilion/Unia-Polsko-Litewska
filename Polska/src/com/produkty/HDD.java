package com.produkty;

/**
 * Klasa opisujaca dyski HDD
 */
public class HDD extends Magnetyczny {
    /**
     * Ilosc glowic dysku
     */
    private int ilosc_glowic;

    /**
     * Konstruktor
     * @param id id produktu
     * @param dane tablica z danymi liczbowymi produktu
     * @param dostepnosc dostepnosc produktu
     * @param producent producent produktu
     * @param rodzaj_nosnika_danych rodzaj nosnika danych
     * @param ilosc_glowic ilosc glowic dysku
     */
    public HDD(int id, float dane[], boolean dostepnosc, String producent, String rodzaj_nosnika_danych, int ilosc_glowic){
        super(id,dane,dostepnosc,producent,rodzaj_nosnika_danych);
        this.ilosc_glowic = ilosc_glowic;
    }

    @Override
    public String toString(){
        return "DYSK HDD " + super.toString() + " ILOSC GLOWIC: " + ilosc_glowic;
    }
}

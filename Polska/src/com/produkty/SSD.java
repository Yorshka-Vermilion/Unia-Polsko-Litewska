package com.produkty;
/**
 * Klasa opisujaca dysk SSD
 */
public class SSD extends Polprzewodnikowy {
    /**
     * Zlacze dysku (M2,SATA...)
     */
    private String zlacze;

    /**
     * Konstruktor
     * @param id id produktu
     * @param dane tablica z danymi liczbowymi produktu
     * @param dostepnosc dostepnosc produktu
     * @param producent producent produktu
     * @param rodzaj_tranzystorow rodzaj tranzystorow
     * @param producent_tranzystorow producent tranzystorow
     * @param liczba_tranzystorow liczba tranzystorow
     * @param zlacze zlacze potrzebne do podpiecia dysku
     */
    public SSD(int id, float dane[], boolean dostepnosc, String producent, String rodzaj_tranzystorow, String producent_tranzystorow, int liczba_tranzystorow, String zlacze){
        super(id,dane,dostepnosc,producent,rodzaj_tranzystorow,producent_tranzystorow,liczba_tranzystorow);
        this.zlacze=zlacze;
    }

    @Override
    public String toString(){
        return "DYSK SSD " + super.toString() + " ZLACZE: " + this.zlacze;
    }
}

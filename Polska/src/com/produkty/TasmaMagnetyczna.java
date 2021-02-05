package com.produkty;

/**
 * Klasa opisujaca naped optyczny
 */
public class TasmaMagnetyczna extends Magnetyczny {
    /**
     * Dlugosc tasmy
     */
    private int dlugosc;
    /**
     * typ logiczny okreslajacy czy tasma jest dwustronna
     */
    private boolean dwustronna;

     /**
     * Konstruktor
     * @param id id produktu
     * @param dane tablica z danymi liczbowymi produktu
     * @param dostepnosc dostepnosc produktu
     * @param producent producent produktu
     * @param rodzaj_nosnika_danych rodzaj nosnika danych
      * @param dlugosc dlugosc tasmy
      * @param dwustronna typ logiczny okreslajacy czy tasma jest dwustronna
     */
    public TasmaMagnetyczna(int id, float dane[], boolean dostepnosc, String producent, String rodzaj_nosnika_danych, int dlugosc, boolean dwustronna){
        super(id,dane,dostepnosc,producent,rodzaj_nosnika_danych);
        this.dlugosc = dlugosc;
        this.dwustronna = dwustronna;
    }

    @Override
    public String toString(){
        return "TASMA MAGNETYCZNA " + super.toString() + " DLUGOSC: " + this.dlugosc + " DWUSTRONNA: " + this.dwustronna;
    }
}

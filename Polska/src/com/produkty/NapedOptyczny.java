package com.produkty;

/**
 * Klasa opisujaca naped optyczny
 */
public class NapedOptyczny extends Optyczny {
    /**
     * Typ napedu (zewnetrzny,wewnetrzny)
     */
    String typ;

    /**
     * Konstruktor
     * @param id id produktu
     * @param dane tablica z danymi liczbowymi produktu
     * @param dostepnosc dostepnosc produktu
     * @param producent producent produktu
     * @param predkosc_obrotowa predkosc obrotowa napedu
     * @param rodzaj_lasera rodzaj lasera napedu
     * @param typ typ napedu
     */
    public NapedOptyczny(int id, float dane[], boolean dostepnosc, String producent, int predkosc_obrotowa, String rodzaj_lasera, String typ){
        super(id,dane,dostepnosc,producent,predkosc_obrotowa,rodzaj_lasera);
        this.typ = typ;
    }

    @Override
    public String toString(){
        return "NAPED OPTYCZNY " + super.toString() + " TYP: " + this.typ;
    }
}

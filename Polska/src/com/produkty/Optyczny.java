package com.produkty;

/**
 * Klasa abstrakcyjna zawierajaca wspolne pola dla wszystkich produktow sklasyfikowanych jako "OPTYCZNY"
 */
public abstract class Optyczny extends Produkt{
    /**
     * Predkosc obrotowa
     */
    protected int predkosc_obrotowa;
    /**
     * Rodzaj lasera (zwyklu, blu-ray...)
     */
    protected String rodzaj_lasera;

    /**
     /**
     * Konstruktor
     * @param id id produktu
     * @param dane tablica z danymi liczbowymi produktu
     * @param dostepnosc dostepnosc produktu
     * @param producent producent produktu
     * @param rodzaj_lasera rodzaj lasera
     */
    Optyczny(int id, float dane[], boolean dostepnosc, String producent,int predkosc_obrotowa,String rodzaj_lasera){
        super(id,dane,dostepnosc,producent);
        this.predkosc_obrotowa=predkosc_obrotowa;
        this.rodzaj_lasera=rodzaj_lasera;
        this.kategoria = "OPTYCZNY";
    }

    public String toString(){
        return super.toString() + " PREDKOSC OBROTOWA: " + this.predkosc_obrotowa + " RODZAJ LASERA: " + rodzaj_lasera;
    }
}

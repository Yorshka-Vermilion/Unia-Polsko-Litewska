package com.produkty;

/**
 * Klasa abstrakcyjna zawierajaca wspolne pola dla wszystkich produktow sklasyfikowanych jako "MAGENTYCZNY"
 */
public abstract class Magnetyczny extends Produkt{
    /**
     * Rodzaj nosnika danych (talerz, tasma...)
     */
    protected String rodzaj_nosnika_danych;

    /**
     * Konstruktor
     * @param id id produktu
     * @param dane tablica z danymi liczbowymi produktu
     * @param dostepnosc dostepnosc produktu
     * @param producent producent produktu
     * @param rodzaj_nosnika_danych rodzaj nosnika danych
     */
    Magnetyczny(int id, float dane[], boolean dostepnosc, String producent,String rodzaj_nosnika_danych){
        super(id,dane,dostepnosc,producent);
        this.rodzaj_nosnika_danych=rodzaj_nosnika_danych;
        this.kategoria = "MAGNETYCZNY";
    }

    @Override
    public String toString(){
        return super.toString() + " RODZAJ NOSNIKA DANYCH: " + this.rodzaj_nosnika_danych;
    }
}

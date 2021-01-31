package com.produkty;

public abstract class Magnetyczny extends Produkt{
    protected String rodzaj_nosnika_danych; //Talerz, tasma
    Magnetyczny(int id, float dane[], boolean dostepnosc, String producent,String rodzaj_nosnika_danych){
        super(id,dane,dostepnosc,producent);
        this.rodzaj_nosnika_danych=rodzaj_nosnika_danych;
        this.kategoria = "MAGNETYCZNY";
    }

    public String toString(){
        return super.toString() + " RODZAJ NOSNIKA DANYCH: " + this.rodzaj_nosnika_danych;
    }
}

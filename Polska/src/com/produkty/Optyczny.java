package com.produkty;

public abstract class Optyczny extends Produkt{
    protected int predkosc_obrotowa;
    protected String rodzaj_lasera; //Zwykly, blu-ray

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

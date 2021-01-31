package com.produkty;

public abstract class Polprzewodnikowy extends Produkt{
    protected String rodzaj_tranzystorow,producent_tranzystorow;
    protected int liczba_tranzystorow;

    Polprzewodnikowy(int id, float dane[], boolean dostepnosc, String producent,String rodzaj_tranzystorow, String producent_tranzystorow, int liczba_tranzystorow){
        super(id,dane,dostepnosc,producent);
        this.rodzaj_tranzystorow=rodzaj_tranzystorow;
        this.producent_tranzystorow=producent_tranzystorow;
        this.liczba_tranzystorow=liczba_tranzystorow;
        this.kategoria = "POLPRZEWODNIKOWY";
    }

    public String toString(){
        return super.toString() + " RODZAJ TRANZYSTOROW: " + this.rodzaj_tranzystorow +
                " PRODUCENT TRANZYSTOROW: " + this.producent_tranzystorow +
                " LICZBA TRANZYSTOROW: " + this.liczba_tranzystorow;
    }
}

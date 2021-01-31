package com.produkty;

public class USB extends Polprzewodnikowy {
    private String interfejs;

    public USB(int id, float dane[], boolean dostepnosc, String producent, String rodzaj_tranzystorow, String producent_tranzystorow, int liczba_tranzystorow, String interfejs){
        super(id,dane,dostepnosc,producent,rodzaj_tranzystorow,producent_tranzystorow,liczba_tranzystorow);
        this.interfejs=interfejs;
    }

    @Override
    public boolean compare() {
        return false;
    }

    @Override
    public boolean equals() {
        return false;
    }

    public String toString(){
        return "PAMIEC USB " + super.toString() + " INTERFEJS: " + this.interfejs;
    }
}

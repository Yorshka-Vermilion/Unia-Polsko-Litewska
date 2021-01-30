package com.produkty;

import com.company.KOLORY;

public class RAM extends Polprzewodnikowy {
    String slot;

    public RAM(int id, float dane[], boolean dostepnosc, String producent, String rodzaj_tranzystorow, String producent_tranzystorow, int liczba_tranzystorow, String slot){
        super(id,dane,dostepnosc,producent,rodzaj_tranzystorow,producent_tranzystorow,liczba_tranzystorow);
        this.slot=slot;
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
        return "PAMIEC RAM " + super.toString() + " SLOT: " + this.slot;
    }
}

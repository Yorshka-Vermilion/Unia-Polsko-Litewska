package com.produkty;

import com.company.KOLORY;

public class SSD extends Polprzewodnikowy {
    String zlacze;

    public SSD(int id, float dane[], boolean dostepnosc, String producent, String rodzaj_tranzystorow, String producent_tranzystorow, int liczba_tranzystorow, String zlacze){
        super(id,dane,dostepnosc,producent,rodzaj_tranzystorow,producent_tranzystorow,liczba_tranzystorow);
        this.zlacze=zlacze;
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
        return "DYSK SSD " + super.toString() + " ZLACZE: " + this.zlacze;
    }
}

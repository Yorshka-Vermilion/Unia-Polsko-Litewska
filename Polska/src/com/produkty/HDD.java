package com.produkty;

import com.company.KOLORY;

public class HDD extends Magnetyczny {
    int ilosc_glowic;

    public HDD(int id, float dane[], boolean dostepnosc, String producent, String rodzaj_nosnika_danych, int ilosc_glowic){
        super(id,dane,dostepnosc,producent,rodzaj_nosnika_danych);
        this.ilosc_glowic = ilosc_glowic;
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
        return "DYSK HDD " + super.toString() + " ILOSC GLOWIC: " + ilosc_glowic;
    }
}

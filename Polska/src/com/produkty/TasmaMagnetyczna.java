package com.produkty;

import com.company.KOLORY;

public class TasmaMagnetyczna extends Magnetyczny {
    int dlugosc;
    boolean dwustronna;
    public TasmaMagnetyczna(int id, float dane[], boolean dostepnosc, String producent, String rodzaj_nosnika_danych, int dlugosc, boolean dwustronna){
        super(id,dane,dostepnosc,producent,rodzaj_nosnika_danych);
        this.dlugosc = dlugosc;
        this.dwustronna = dwustronna;
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
        return "TASMA MAGNETYCZNA " + super.toString() + " DLUGOSC: " + this.dlugosc + " DWUSTRONNA: " + this.dwustronna;
    }
}

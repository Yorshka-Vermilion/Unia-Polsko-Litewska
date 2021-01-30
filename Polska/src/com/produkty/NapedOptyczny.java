package com.produkty;

import com.company.KOLORY;

public class NapedOptyczny extends Optyczny {
    String typ; //zewnetrzny/wewnetrzny

    public NapedOptyczny(int id, float dane[], boolean dostepnosc, String producent, int predkosc_obrotowa, String rodzaj_lasera, String typ){
        super(id,dane,dostepnosc,producent,predkosc_obrotowa,rodzaj_lasera);
        this.typ = typ;
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
        return "NAPED OPTYCZNY " + super.toString() + " TYP: " + this.typ;
    }
}

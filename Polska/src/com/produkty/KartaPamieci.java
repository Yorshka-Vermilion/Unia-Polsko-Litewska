package com.produkty;

import com.company.KOLORY;

public class KartaPamieci extends Polprzewodnikowy {
    String typ; //sd,microsd...
    String przeznaczenie; //ogolne,telefon,aparat...

    public KartaPamieci(int id, float dane[], boolean dostepnosc, String producent, String rodzaj_tranzystorow, String producent_tranzystorow, int liczba_tranzystorow, String typ, String przeznaczenie){
        super(id,dane,dostepnosc,producent,rodzaj_tranzystorow,producent_tranzystorow,liczba_tranzystorow);
        this.typ=typ;
        this.przeznaczenie=przeznaczenie;
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
        return "KARTA PAMIECI " + super.toString() + " TYP: " + this.typ + " PRZEZNACZENIE: " + this.przeznaczenie;
    }
}

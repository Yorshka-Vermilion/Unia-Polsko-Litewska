package com.produkty;

public class Plyta extends Optyczny {
    private String typ; // DVD,CD,RW-DVD itp..
    public Plyta(int id, float dane[], boolean dostepnosc, String producent, int predkosc_obrotowa, String rodzaj_lasera, String typ){
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
        return "PLYTA " + super.toString() + " TYP: " + this.typ;
    }
}

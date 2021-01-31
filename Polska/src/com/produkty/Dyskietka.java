package com.produkty;


public class Dyskietka extends Magnetyczny {
    private String material_krazka;

    public Dyskietka(int id, float dane[], boolean dostepnosc, String producent, String rodzaj_nosnika_danych, String material_krazka){
        super(id,dane,dostepnosc,producent,rodzaj_nosnika_danych);
        this.material_krazka = material_krazka;
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
        return "DYSKIETKA " + super.toString() + " MATERIAL KRAZKA: " + this.material_krazka;
    }
}

package com.produkty;

public abstract class Produkt implements ProduktCore {
    protected int id;
    protected float szerokosc, wysokosc, glebokosc, waga, szybkosc_zapisu, szybkosc_odczytu, pojemnosc, cena;
    protected boolean dostepnosc;
    protected String producent,kategoria;
    Produkt(int id, float dane[], boolean dostepnosc, String producent){
        this.id=id;
        this.szerokosc=dane[0];
        this.wysokosc=dane[1];
        this.glebokosc=dane[2];
        this.waga=dane[3];
        this.szybkosc_odczytu=dane[4];
        this.szybkosc_zapisu=dane[5];
        this.pojemnosc=dane[6];
        this.cena=dane[7];
        this.dostepnosc=dostepnosc;
        this.producent=producent;
    }

    public String toString(){
        return "ID: " + this.id
                + " WYMIARY: " + this.szerokosc + "x" + this.wysokosc + "x" + this.glebokosc +
                " WAGA: " + this.waga + " SZYBKOSC ZAPISU: " + this.szybkosc_zapisu + " SZYBKOSC ODCZYTU: " + this.szybkosc_odczytu +
                " POJEMNOSC: " + this.pojemnosc + " CENA: " + this.cena + " DOSTEPNOSC: " + this.dostepnosc + " PRODUCENT " + this.producent;
    }

    public String getKategoria(){return this.kategoria;};

    public float getCena(){return this.cena;};
}

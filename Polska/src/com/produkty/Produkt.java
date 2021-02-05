package com.produkty;

 /**
 * Klasa abstrakcyjna zawierajaca wspolne pola oraz funkncje wszystkich produktow
 */
public abstract class Produkt implements ProduktCore {
    /**
     * id produktu
     */
    protected int id;
     /**
      * szerokosc produktu
      */
    protected float szerokosc;
     /**
      * wysokosc produktu
      */
    protected float wysokosc;
     /**
      * glebokosc produktu
      */
    protected float glebokosc;
     /**
      * waga produktu
      */
    protected float waga;
     /**
      * szybkosc_zapisu produktu
      */
    protected float szybkosc_zapisu;
     /**
      * szybkosc_odczytu produktu
      */
    protected float szybkosc_odczytu;
     /**
      * pojemnosc produktu
      */
    protected float pojemnosc;
     /**
      * cena produktu
      */
    protected float cena;
     /**
      * dostepnosc produktu
      */
    protected boolean dostepnosc;
     /**
      * producent produktu
      */
    protected String producent;
     /**
      * kategoria produktu
      */
    protected String kategoria;

     /**
      * Konstruktor
      * @param id id produktu
      * @param dane tablica z danymi liczbowymi produktu
      * @param dostepnosc dostepnosc produktu
      * @param producent producent produktu
      */
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

     /**
      * Funkcja sluzaca do pobrania kategorii produktu
      * @return Kategoria produktu
      */
    public String getKategoria(){return this.kategoria;};

     /**
      * Funkcja sluzaca do pobrania ceny produktu
      * @return Cena produktu
      */
    public float getCena(){return this.cena;};

     @Override
     public boolean equals(Produkt cos) {
         return this == cos;
     }

     @Override
     public String compare(Produkt cos){
        if(this.id < cos.id) return "WIEKSZY";
        else if(this.id > cos.id) return "MNIEJSZY";
        else return "ROWNE";
     }
 }

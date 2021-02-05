package com.produkty;

/**
 * Klasa abstrakcyjna zawierajaca wspolne pola dla wszystkich produktow sklasyfikowanych jako "POLPRZEWODNIKOWY"
 */
public abstract class Polprzewodnikowy extends Produkt{
    /**
     * Rodzaj uzytych tranzystorow
     */
    protected String rodzaj_tranzystorow;
    /**
     * Producent uzytych tranzystorow
     */
    protected String producent_tranzystorow;
    /**
     * Liczba uzytych tranzystorow
     */
    protected int liczba_tranzystorow;

    /**
     * Konstruktor
     * @param id id produktu
     * @param dane tablica z danymi liczbowymi produktu
     * @param dostepnosc dostepnosc produktu
     * @param producent producent produktu
     * @param rodzaj_tranzystorow rodzaj tranzystorow
     * @param producent_tranzystorow producent tranzystorow
     * @param liczba_tranzystorow liczba tranzystorow
     */
    Polprzewodnikowy(int id, float dane[], boolean dostepnosc, String producent,String rodzaj_tranzystorow, String producent_tranzystorow, int liczba_tranzystorow){
        super(id,dane,dostepnosc,producent);
        this.rodzaj_tranzystorow=rodzaj_tranzystorow;
        this.producent_tranzystorow=producent_tranzystorow;
        this.liczba_tranzystorow=liczba_tranzystorow;
        this.kategoria = "POLPRZEWODNIKOWY";
    }

    public String toString(){
        return super.toString() + " RODZAJ TRANZYSTOROW: " + this.rodzaj_tranzystorow +
                " PRODUCENT TRANZYSTOROW: " + this.producent_tranzystorow +
                " LICZBA TRANZYSTOROW: " + this.liczba_tranzystorow;
    }
}

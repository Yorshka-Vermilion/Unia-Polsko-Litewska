package com.produkty;

/**
 * Interfejs zawierajacy metody produktow
 */
public interface ProduktCore { // Hierarchia do ogarniecia
    /**
     * @return Konwersja produktu do ciagu znakow
     */
    public String toString();

    /**
     * Sprawdza jaki w stosunku do tego produktu jest podany w argumencie produkt
     * @param cos Produkt do porownania
     * @return (WIekszy jesli wiekszy, Mniejszy jesli mniejszy, Rowny jesli rowny)
     */
    public String compare(Produkt cos);

    /**
     * Porownuje czy produkty sa takie same
     * @param cos Produkt do porownania
     * @return True jesli takie same lub false jesli nie
     */
    public boolean equals(Produkt cos);

}

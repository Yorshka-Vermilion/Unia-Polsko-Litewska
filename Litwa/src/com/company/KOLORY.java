package com.company;

public enum KOLORY {
    RESET("\u001B[0m"),
    CZARNY("\u001B[30m"),
    CZERWONY("\u001B[31m"),
    ZIELONY("\u001B[32m"),
    ZOLTY("\u001B[33m"),
    NIEBIESKI("\u001B[34m"),
    FIOLETOWY("\u001B[35m"),
    CYJAN("\u001B[36m"),
    BIALY("\u001B[37m");

    String kolor;
    KOLORY(String kolor){
        this.kolor = kolor;
    }
}

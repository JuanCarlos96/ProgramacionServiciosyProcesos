package Tema3.EjExtra16;

import java.io.Serializable;

public class Resultado implements Serializable{
    private int totaldiez, dobleseis, sumatotal;

    public Resultado(int totaldiez, int dobleseis, int sumatotal) {
        this.totaldiez = totaldiez;
        this.dobleseis = dobleseis;
        this.sumatotal = sumatotal;
    }

    public int getTotaldiez() {
        return totaldiez;
    }

    public int getDobleseis() {
        return dobleseis;
    }

    public int getSumatotal() {
        return sumatotal;
    }
}
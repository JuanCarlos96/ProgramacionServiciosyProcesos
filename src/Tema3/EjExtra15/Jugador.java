package Tema3.EjExtra15;

import java.io.Serializable;

public class Jugador implements Serializable{
    private int puntuacion, tiradas;

    public Jugador(int puntuacion, int tiradas) {
        this.puntuacion = puntuacion;
        this.tiradas = tiradas;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public int getTiradas() {
        return tiradas;
    }
}
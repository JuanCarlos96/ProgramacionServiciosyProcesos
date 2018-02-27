package Tema3.EjExtra17;

import java.io.Serializable;

public class DireccionIP implements Serializable{
    private int octeto1, octeto2, octeto3, octeto4;

    public DireccionIP(int octeto1, int octeto2, int octeto3, int octeto4) {
        this.octeto1 = octeto1;
        this.octeto2 = octeto2;
        this.octeto3 = octeto3;
        this.octeto4 = octeto4;
    }

    public int getOcteto1() {
        return octeto1;
    }

    @Override
    public String toString() {
        return octeto1+"."+octeto2+"."+octeto3+"."+octeto4;
    }
}
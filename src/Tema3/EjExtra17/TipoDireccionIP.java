package Tema3.EjExtra17;

import java.io.Serializable;

public class TipoDireccionIP implements Serializable{
    private String ip;
    private char tipo;

    public TipoDireccionIP(String ip, char tipo) {
        this.ip = ip;
        this.tipo = tipo;
    }

    public String getIp() {
        return ip;
    }

    public char getTipo() {
        return tipo;
    }
}
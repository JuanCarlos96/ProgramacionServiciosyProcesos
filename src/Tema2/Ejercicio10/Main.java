package Tema2.Ejercicio10;

public class Main {
    public static void main(String[] args) {
        Cuenta cuenta = new Cuenta(0,1000);
        Persona p1 = new Persona("Pepe",cuenta);
        Persona p2 = new Persona("María",cuenta);
        p1.start();
        p2.start();
    }
}
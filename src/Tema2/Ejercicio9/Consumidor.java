package Tema2.Ejercicio9;

public class Consumidor extends Thread {
    private Cola cola;

    public Consumidor(Cola c) {
        cola = c;
    }

    public void run() {
        String cadena = null;
        for (int i = 0; i < 6; i++) {
            cadena = cola.get(); //recoge el numero
            System.out.println(cadena);
        }
    }
}
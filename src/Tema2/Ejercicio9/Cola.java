package Tema2.Ejercicio9;

public class Cola {
    private String cadena;
    private boolean disponible = false; //inicialmente cola vacía

    public synchronized String get() {
        while (disponible == false) {
            try {
                wait();
            } catch (InterruptedException e) {}
        }
        disponible = false;
        notifyAll();
        return cadena;
    }

    public synchronized void put(String cadena_nueva) {
        while (disponible == true) {
            try {
            wait();
            } catch (InterruptedException e) {}
        }
        cadena = cadena_nueva;
        disponible = true;
        notifyAll();
    }
}
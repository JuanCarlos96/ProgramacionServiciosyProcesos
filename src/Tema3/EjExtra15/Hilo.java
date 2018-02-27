package Tema3.EjExtra15;

import java.io.*;
import java.net.Socket;
import java.util.Random;

public class Hilo extends Thread{
    private Socket c;
    private Random rnd = new Random();
    private ObjectOutputStream oos;
    private ObjectInputStream ois;

    public Hilo(Socket c) {
        this.c = c;
        
        try {
            oos = new ObjectOutputStream(c.getOutputStream());
            ois = new ObjectInputStream(c.getInputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            Jugador jugador = (Jugador) ois.readObject();
            int puntuacion = jugador.getPuntuacion();
            int tiradas = jugador.getTiradas();
            
            int suma = 0;
            int i;
            
            for (i=1 ; i<=tiradas; i++) {
                suma += rnd.nextInt(6)+1;
                if(suma>=puntuacion){
                    oos.writeObject(new Resultado(suma, i));
                    break;
                }
            }
            
            if(suma<puntuacion){
                oos.writeObject(new Resultado(suma, i-1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
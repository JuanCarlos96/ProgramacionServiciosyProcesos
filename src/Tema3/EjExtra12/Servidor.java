package Tema3.EjExtra12;

import java.io.IOException;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor {
    public static void main(String[] args) {
        try {
            ServerSocket servidor = new ServerSocket(49500);
            System.out.println("Servidor iniciado");
            while(true){
                Socket cliente;
                System.out.println("Esperando cliente...");
                cliente = servidor.accept();
                System.out.println("Cliente conectado");
                Hilo h = new Hilo(cliente);
                h.start();
            }
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
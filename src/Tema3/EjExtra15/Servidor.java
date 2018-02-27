package Tema3.EjExtra15;

import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) {
        try{
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
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
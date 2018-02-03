package Tema3.EjExtra4;

import java.net.*;
import java.io.*;
import java.util.Random;

public class Servidor {
    public static void main(String[] args) {
        try {
            Random rnd = new Random();
            ServerSocket servidor = new ServerSocket(49500);
            Socket cliente;
            
            System.out.println("Esperando cliente...");
            cliente = servidor.accept();
            System.out.println("Cliente conectado");
            
            BufferedReader br = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
            int puntuacion = Integer.parseInt(br.readLine());
            System.out.println("Puntuación leída");
            int tiradas = Integer.parseInt(br.readLine());
            System.out.println("Tiradas leídas");
            
            int suma = 0;
            PrintWriter pw = new PrintWriter(cliente.getOutputStream(),true);
            
            for (int i=1 ; i<=tiradas; i++) {
                suma += rnd.nextInt(6)+1;
                if(suma>=puntuacion){
                    pw.println("El jugador ha llegado a la puntuación deseada en "+i+" tiradas");
                    break;
                }
            }
            
            if(suma<puntuacion){
                pw.println("El jugador no ha llegado a la puntuación establecida");
            }
            
            pw.close();
            br.close();
            cliente.close();
            servidor.close();
        } catch (Exception e) {
            System.out.println("Error");
        }
    }
}
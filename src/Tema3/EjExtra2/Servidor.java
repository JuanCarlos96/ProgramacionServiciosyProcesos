package Tema3.EjExtra2;

import java.io.*;
import java.net.*;

public class Servidor {
    public static void main(String[] args) {
        try {
            ServerSocket servidor = new ServerSocket(49500);
            Socket cliente;
            
            System.out.println("Esperando cliente...");
            cliente = servidor.accept();
            System.out.println("Cliente conectado");
            
            BufferedReader br = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
            boolean esPrimo = nPrimo(Integer.parseInt(br.readLine()));
            System.out.println("Calculando...");
            
            PrintWriter pw = new PrintWriter(cliente.getOutputStream(),true);
            pw.println(esPrimo);
            System.out.println("Enviando resultado al cliente...");
            
            pw.close();
            br.close();
            cliente.close();
            servidor.close();
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error");
        }
    }
    
    private static boolean nPrimo(int numero){
        if(numero==2 || numero==1) return true;
        
        for(int i=2; i<numero; i++){
            if(numero%i==0){
                return false;
            }
        }
        
        return true;
    }
}
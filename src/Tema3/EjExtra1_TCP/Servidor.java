package Tema3.EjExtra1_TCP;

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
            int termino = nFibonacci(Integer.parseInt(br.readLine()));
            System.out.println("Calculando término...");
            
            PrintWriter pw = new PrintWriter(cliente.getOutputStream(),true);
            pw.println(termino);
            System.out.println("Enviando término al cliente...");
            
            pw.close();
            br.close();
            cliente.close();
            servidor.close();
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error");
        }
    }
    
    private static int nFibonacci(int ntermino){
        int n=1, n1=1, n2=1;
        
        for(int i=2; i<ntermino; i++){
            n=n1+n2;
            n1=n2;
            n2=n;
        }
        
        return n;
    }
}
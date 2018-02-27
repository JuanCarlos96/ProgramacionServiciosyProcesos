package Tema3.EjExtra13;

import java.io.*;
import java.io.PrintWriter;
import java.net.Socket;

public class Hilo extends Thread{
    private Socket c;
    private BufferedReader br;
    private PrintWriter pw;

    public Hilo(Socket c) {
        this.c = c;
        
        try {
            pw = new PrintWriter(c.getOutputStream(), true);
            br = new BufferedReader(new InputStreamReader(c.getInputStream()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try{
            boolean esPrimo = nPrimo(Integer.parseInt(br.readLine()));
            System.out.println("Calculando...");
            
            pw.println(esPrimo);
            System.out.println("Enviando resultado al cliente...");
            
            pw.close();
            br.close();
            c.close();
        }catch(IOException ioe){
            ioe.printStackTrace();
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
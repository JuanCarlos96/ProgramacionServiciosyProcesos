package Tema3.EjExtra12;

import java.net.Socket;
import java.io.*;

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
            int termino = nFibonacci(Integer.parseInt(br.readLine()));
            System.out.println("Calculando término...");

            pw.println(termino);
            System.out.println("Enviando término al cliente...");

            pw.close();
            br.close();
            c.close();
        }catch(IOException ioe){
            ioe.printStackTrace();
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
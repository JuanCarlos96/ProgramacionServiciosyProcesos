package Tema3.EjExtra14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Arrays;

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
            int size = Integer.parseInt(br.readLine());
            System.out.println("Tamaño leído");
            
            int[] vector = new int[size];
            
            for (int i = 0; i < size; i++) {
                vector[i] = Integer.parseInt(br.readLine());
            }
            System.out.println("Vector recibido");
            Arrays.sort(vector);
            System.out.println("Vector ordenado");
            
            for (int i = 0; i < size; i++) {
                pw.println(vector[i]);
            }
            System.out.println("Vector enviado");
            
            pw.close();
            br.close();
            c.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
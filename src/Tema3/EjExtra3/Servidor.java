package Tema3.EjExtra3;

import java.net.*;
import java.io.*;
import java.util.Arrays;

public class Servidor {
    public static void main(String[] args) {
        try {
            ServerSocket servidor = new ServerSocket(49500);
            Socket cliente;
            
            System.out.println("Esperando cliente...");
            cliente = servidor.accept();
            System.out.println("Cliente conectado");
            
            BufferedReader br = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
            int size = Integer.parseInt(br.readLine());
            System.out.println("Tamaño leído");
            
            int[] vector = new int[size];
            
            for (int i = 0; i < size; i++) {
                vector[i] = Integer.parseInt(br.readLine());
            }
            System.out.println("Vector recibido");
            Arrays.sort(vector);
            System.out.println("Vector ordenado");
            PrintWriter pw = new PrintWriter(cliente.getOutputStream(), true);
            
            for (int i = 0; i < size; i++) {
                pw.println(vector[i]);
            }
            System.out.println("Vector enviado");
            
            pw.close();
            br.close();
            cliente.close();
            servidor.close();
        } catch (Exception e) {
        }
    }
}
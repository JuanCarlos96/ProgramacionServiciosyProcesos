package Tema3.EjExtra3_TCP;

import java.net.Socket;
import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        try {
            Random rnd = new Random();
            Scanner teclado = new Scanner(System.in);
            Socket servidor = new Socket("localhost", 49500);
            
            System.out.print("Introduzca tamaño del array: ");
            int size = Integer.parseInt(teclado.nextLine());
            
            PrintWriter pw = new PrintWriter(servidor.getOutputStream(), true);
            pw.println(size);
            
            System.out.print("Introduzca inicio del intervalo: ");
            int min = Integer.parseInt(teclado.nextLine());
            
            System.out.print("Introduzca final del intervalo: ");
            int max = Integer.parseInt(teclado.nextLine());
            
            int[] vector = new int[size];
            
            for (int i = 0; i < size; i++) {
                vector[i] = rnd.nextInt((max-min)+1)+min;
            }
            
            for (int i = 0; i < size; i++) {
                pw.println(vector[i]);
            }
            System.out.println("Vector enviado");
            
            BufferedReader br = new BufferedReader(new InputStreamReader(servidor.getInputStream()));
            
            for (int i = 0; i < size; i++) {
                System.out.print(br.readLine()+" ");
            }
            
            br.close();
            pw.close();
            servidor.close();
        } catch (Exception e) {
        }
    }
}
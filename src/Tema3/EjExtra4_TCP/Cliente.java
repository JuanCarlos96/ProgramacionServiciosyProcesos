package Tema3.EjExtra4_TCP;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        try {
            Scanner teclado = new Scanner(System.in);
            Socket servidor = new Socket("localhost", 49500);
            PrintWriter pw = new PrintWriter(servidor.getOutputStream(), true);
            
            System.out.print("Introduzca puntuación: ");
            int puntuacion = Integer.parseInt(teclado.nextLine());
            pw.println(puntuacion);
            
            System.out.print("Introduzca tiradas: ");
            int tiradas = Integer.parseInt(teclado.nextLine());
            pw.println(tiradas);
            
            BufferedReader br = new BufferedReader(new InputStreamReader(servidor.getInputStream()));
            System.out.println(br.readLine());
            
            br.close();
            pw.close();
            servidor.close();
        } catch (Exception e) {
            System.out.println("Error");
        }
    }
}
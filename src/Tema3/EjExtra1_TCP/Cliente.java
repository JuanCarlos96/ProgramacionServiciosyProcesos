package Tema3.EjExtra1_TCP;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        try {
            Scanner teclado = new Scanner(System.in);
            String host = "localhost";
            int port = 49500;
            Socket servidor = new Socket(host, port);
            
            System.out.print("Introduzca que término de Fibonacci desea averiguar: ");
            int termino = Integer.parseInt(teclado.nextLine());
            
            PrintWriter pw = new PrintWriter(servidor.getOutputStream(),true);
            pw.println(termino);
            System.out.println("Enviando datos al servidor...");
            
            BufferedReader br = new BufferedReader(new InputStreamReader(servidor.getInputStream()));
            System.out.println("El término de Fibonacci es: "+br.readLine());
            
            br.close();
            pw.close();
            servidor.close();
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error");
        }
    }
}
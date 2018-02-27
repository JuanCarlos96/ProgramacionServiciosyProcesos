package Tema3.EjExtra13;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        try {
            Scanner teclado = new Scanner(System.in);
            String host = "localhost";
            int port = 49500;
            Socket servidor = new Socket(host, port);
            
            System.out.print("Introduzca un número: ");
            int termino = Integer.parseInt(teclado.nextLine());
            
            PrintWriter pw = new PrintWriter(servidor.getOutputStream(),true);
            pw.println(termino);
            System.out.println("Enviando datos al servidor...");
            
            BufferedReader br = new BufferedReader(new InputStreamReader(servidor.getInputStream()));
            boolean esPrimo = Boolean.valueOf(br.readLine());
            
            if(esPrimo){
                System.out.println("El número introducido es primo");
            }else{
                System.out.println("El número introducido no es primo");
            }
            
            br.close();
            pw.close();
            servidor.close();
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error");
        }
    }
}
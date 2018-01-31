package Tema3.Ejercicio3;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Servidor {
    public static void main(String[] args) {
        int puerto,conexiones = 49500;
        ServerSocket servidor = null;
        Socket cliente = null;
        Scanner teclado = new Scanner(System.in);
        
        try {
            servidor = new ServerSocket(49500);
            
            System.out.print("Introduzca cuantos clientes quieres que se conecten: ");
            conexiones = Integer.parseInt(teclado.nextLine());
            
            for(int i=1; i<=conexiones; i++){
                System.out.println("Esperando cliente...");
                cliente = servidor.accept();
                DataOutputStream dos = new DataOutputStream(cliente.getOutputStream());
                dos.writeUTF("Eres el cliente número "+i);
                dos.close();
                cliente.close();
            }
        } catch (IOException e) {
        }
    }
}
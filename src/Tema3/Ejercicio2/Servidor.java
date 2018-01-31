package Tema3.Ejercicio2;

import java.io.*;
import java.net.*;

public class Servidor {
    public static void main(String[] args) {
        int puerto = 49500;
        ServerSocket servidor = null;
        Socket cliente = null;
        
        try {
            servidor = new ServerSocket(puerto);
            System.out.println("Esperando conexión...");
            cliente = servidor.accept();
            
            DataOutputStream salida = new DataOutputStream(cliente.getOutputStream());
            salida.writeUTF("Hola cliente");
            
            DataInputStream entrada = new DataInputStream(cliente.getInputStream());
            System.out.println("Mensaje recibido del cliente: "+entrada.readUTF());
            
            entrada.close();
            salida.close();
            cliente.close();
            servidor.close();
        } catch (Exception e) {
        }
    }
}
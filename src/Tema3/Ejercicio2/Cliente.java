package Tema3.Ejercicio2;

import java.io.*;
import java.net.*;

public class Cliente {
    public static void main(String[] args) {
        String host = "localhost";
        int puerto = 49500;
        
        try{
            Socket cliente = new Socket(host, puerto);
            
            DataInputStream entrada = new DataInputStream(cliente.getInputStream());
            String mensaje = entrada.readUTF();
            System.out.println("Mensaje recibido del servidor: "+mensaje);
            System.out.println("Reenviando mensaje...");
            
            DataOutputStream salida = new DataOutputStream(cliente.getOutputStream());
            salida.writeUTF(mensaje);
            
            salida.close();
            entrada.close();
            cliente.close();
        }catch(IOException e){
        }
        
        
    }
}
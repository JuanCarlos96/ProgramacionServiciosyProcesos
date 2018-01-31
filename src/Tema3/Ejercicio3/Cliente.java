package Tema3.Ejercicio3;

import java.io.*;
import java.net.*;

public class Cliente {
    public static void main(String[] args) {
        String host = "localhost";
        int puerto = 49500;
        Socket cliente = null;
        
        try {
            cliente = new Socket(host, puerto);
            
            DataInputStream dis = new DataInputStream(cliente.getInputStream());
            System.out.println(dis.readUTF());
            
            dis.close();
            cliente.close();
        } catch (IOException e) {
        }
    }
}
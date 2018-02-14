package Tema3.EjExtra9_TCP;

import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class Servidor {
    public static void main(String[] args) {
        try {
            ServerSocket servidor = new ServerSocket(49500);
            Socket cliente;
            float media=0;
            
            System.out.println("Esperando cliente...");
            cliente = servidor.accept();
            System.out.println("Cliente conectado");
            
            ObjectInputStream ois = new ObjectInputStream(cliente.getInputStream());
            ArrayList empleados = (ArrayList) ois.readObject();
            
            for(Object obj:empleados){
                Empleado e = (Empleado) obj;
                media+=e.getSalario();
            }
            media = media/empleados.size();
            
            PrintWriter pw = new PrintWriter(cliente.getOutputStream(), true);
            pw.println(media);
            
            pw.close();
            ois.close();
            cliente.close();
            servidor.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
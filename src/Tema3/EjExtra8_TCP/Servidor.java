package Tema3.EjExtra8_TCP;

import java.io.*;
import java.net.*;

public class Servidor {
    public static void main(String[] args) {
        try {
            ServerSocket servidor = new ServerSocket(49500);
            Socket cliente;
            
            System.out.println("Esperando cliente...");
            cliente = servidor.accept();
            System.out.println("Cliente conectado");
            
            ObjectInputStream ois = new ObjectInputStream(cliente.getInputStream());
            Empleado empleado = (Empleado) ois.readObject();
            
            int antiguedad = empleado.getAntiguedad();
            
            if(antiguedad>=5 && antiguedad<10){
                empleado.setSalario(empleado.getSalario()+(empleado.getSalario()*0.05f));
            }else if(antiguedad>=10 && antiguedad<15){
                empleado.setSalario(empleado.getSalario()+(empleado.getSalario()*0.10f));
            }else if(antiguedad>=15){
                empleado.setSalario(empleado.getSalario()+(empleado.getSalario()*0.15f));
            }
            System.out.println("Salario actualizado");
            
            ObjectOutputStream oos = new ObjectOutputStream(cliente.getOutputStream());
            oos.writeObject(empleado);
            
            oos.close();
            ois.close();
            cliente.close();
            servidor.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
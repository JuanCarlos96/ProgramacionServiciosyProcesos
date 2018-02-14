package Tema3.EjExtra8_UDP;

import java.io.*;
import java.net.*;

public class Servidor {
    public static void main(String[] args) {
        try {
            DatagramSocket servidor = new DatagramSocket(49500);
            byte[] recibido = new byte[1024];
            byte[] enviado = new byte[1024];
            
            System.out.println("Esperando datagrama...");
            DatagramPacket paqRecibido = new DatagramPacket(recibido, recibido.length);
            servidor.receive(paqRecibido);
            ByteArrayInputStream bais = new ByteArrayInputStream(recibido);
            ObjectInputStream ois = new ObjectInputStream(bais);
            Empleado empleado = (Empleado) ois.readObject();
            System.out.println("Empleado leído");
            
            int antiguedad = empleado.getAntiguedad();
            
            if(antiguedad>=5 && antiguedad<10){
                empleado.setSalario(empleado.getSalario()+(empleado.getSalario()*0.05f));
            }else if(antiguedad>=10 && antiguedad<15){
                empleado.setSalario(empleado.getSalario()+(empleado.getSalario()*0.10f));
            }else if(antiguedad>=15){
                empleado.setSalario(empleado.getSalario()+(empleado.getSalario()*0.15f));
            }
            System.out.println("Salario actualizado");
            
            InetAddress clienteIP = paqRecibido.getAddress();
            int puerto = paqRecibido.getPort();
            
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(empleado);
            enviado = baos.toByteArray();
            DatagramPacket paqEnviado = new DatagramPacket(enviado, enviado.length, clienteIP, puerto);
            servidor.send(paqEnviado);
            
            oos.close();
            ois.close();
            servidor.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
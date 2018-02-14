package Tema3.EjExtra9_UDP;

import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class Servidor {
    public static void main(String[] args) {
        try {
            DatagramSocket servidor = new DatagramSocket(49500);
            byte[] recibido = new byte[1024];
            byte[] enviado = new byte[1024];
            float media=0;
            
            System.out.println("Esperando datagrama...");
            DatagramPacket paqRecibido = new DatagramPacket(recibido, recibido.length);
            servidor.receive(paqRecibido);
            ByteArrayInputStream bais = new ByteArrayInputStream(recibido);
            ObjectInputStream ois = new ObjectInputStream(bais);
            ArrayList empleados = (ArrayList) ois.readObject();
            System.out.println("Empleados leídos");
            
            for(Object obj:empleados){
                Empleado e = (Empleado) obj;
                media+=e.getSalario();
            }
            media = media/empleados.size();
            
            InetAddress clienteIP = paqRecibido.getAddress();
            int puerto = paqRecibido.getPort();
            
            enviado = Float.toString(media).getBytes();
            DatagramPacket paqEnviado = new DatagramPacket(enviado, enviado.length, clienteIP, puerto);
            servidor.send(paqEnviado);
            
            ois.close();
            servidor.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
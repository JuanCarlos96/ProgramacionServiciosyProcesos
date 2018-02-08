package Tema3.EjExtra3_UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Servidor {
    public static void main(String[] args) {
        try {
            DatagramSocket servidor = new DatagramSocket(49500);
            byte[] recibido = new byte[1024];
            byte[] enviado = new byte[1024];
            
            System.out.println("Esperando datagrama...");
            DatagramPacket paqRecibido = new DatagramPacket(recibido, recibido.length);
            servidor.receive(paqRecibido);
            String tamanio = new String(paqRecibido.getData());
            System.out.println("Tamaño recibido");
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
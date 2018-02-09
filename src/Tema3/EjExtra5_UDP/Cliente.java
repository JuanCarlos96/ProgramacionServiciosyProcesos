package Tema3.EjExtra5_UDP;

import java.net.*;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        try {
            Scanner teclado = new Scanner(System.in);
            DatagramSocket cliente = new DatagramSocket();
            byte[] enviado = new byte[1024];
            byte[] recibido = new byte[1024];
            
            InetAddress servidorIP = InetAddress.getLocalHost();
            System.out.print("Introduce tiradas: ");
            String tiradas = teclado.nextLine();
            enviado = tiradas.getBytes();
            DatagramPacket paqEnviado = new DatagramPacket(enviado, enviado.length, servidorIP, 49500);
            cliente.send(paqEnviado);
            System.out.println("Tiradas enviadas");
            
            DatagramPacket paqRecibido = new DatagramPacket(recibido, recibido.length);
            cliente.receive(paqRecibido);
            String resultado = new String(paqRecibido.getData());
            System.out.println(resultado.trim());
            
            cliente.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
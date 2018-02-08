package Tema3.EjExtra2_UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        try{
            Scanner teclado = new Scanner(System.in);
            DatagramSocket cliente = new DatagramSocket();
            byte[] enviado = new byte[1024];
            byte[] recibido = new byte[1024];
            
            InetAddress servidorIP = InetAddress.getLocalHost();
            
            System.out.print("Introduce número: ");
            String n = teclado.nextLine();
            
            enviado = n.getBytes();
            DatagramPacket paqEnviado = new DatagramPacket(enviado, enviado.length, servidorIP, 49500);
            cliente.send(paqEnviado);
            
            DatagramPacket paqRecibido = new DatagramPacket(recibido, recibido.length);
            cliente.receive(paqRecibido);
            String resultado = new String(paqRecibido.getData());
            System.out.println(resultado.trim());
            
            cliente.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
package Tema3.EjExtra6_UDP;

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
            
            System.out.print("Introduzca dirección IP: ");
            String[] cadenaIP = teclado.nextLine().split("\\.");
            
            int[] ip = new int[4];
            
            for(int i=0; i<cadenaIP.length; i++){
                ip[i] = Integer.parseInt(cadenaIP[i]);
            }
            
            if(ip[0]<0 || ip[0]>255 || ip[1]<0 || ip[1]>255 || ip[2]<0 || ip[2]>255 || ip[3]<0 || ip[3]>255){
                System.out.println("Formato no válido");
            }else{
                enviado = cadenaIP[0].getBytes();
                DatagramPacket paqEnviado = new DatagramPacket(enviado, enviado.length, servidorIP, 49500);
                cliente.send(paqEnviado);
                System.out.println("IP enviada");
                
                DatagramPacket paqRecibido = new DatagramPacket(recibido, recibido.length);
                cliente.receive(paqRecibido);
                String resultado = new String(paqRecibido.getData());
                System.out.println(resultado.trim());
            }
            
            cliente.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
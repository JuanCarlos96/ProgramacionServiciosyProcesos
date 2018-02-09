package Tema3.EjExtra6_UDP;

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
            String octeto = new String(paqRecibido.getData());
            int t = Integer.parseInt(octeto.trim());
            System.out.println("IP leída");
            
            InetAddress clienteIP = paqRecibido.getAddress();
            int puerto = paqRecibido.getPort();
            
            String resultado;
            
            if(t<=127){
                resultado = "La IP es de clase A";
            }else if(t>=128 && t<=191){
                resultado = "La IP es de clase B";
            }else if(t>=192 && t<=223){
                resultado = "La IP es de clase C";
            }else{
                resultado = "La IP es de otra clase";
            }
            
            enviado = resultado.getBytes();
            DatagramPacket paqEnviado = new DatagramPacket(enviado, enviado.length, clienteIP, puerto);
            servidor.send(paqEnviado);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
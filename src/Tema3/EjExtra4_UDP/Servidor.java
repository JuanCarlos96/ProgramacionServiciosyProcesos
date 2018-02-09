package Tema3.EjExtra4_UDP;

import java.net.*;
import java.util.Random;

public class Servidor {
    public static void main(String[] args) {
        try {
            Random rnd = new Random();
            DatagramSocket servidor = new DatagramSocket(49500);
            byte[] recibido = new byte[1024];
            byte[] enviado = new byte[1024];
            int suma = 0;
            
            System.out.println("Esperando datagrama...");
            DatagramPacket paqRecibido = new DatagramPacket(recibido, recibido.length);
            servidor.receive(paqRecibido);
            String tiradas = new String(paqRecibido.getData());
            int t = Integer.parseInt(tiradas.trim());
            System.out.println("Tiradas leídas");
            
            servidor.receive(paqRecibido);
            String puntos = new String(paqRecibido.getData());
            int p = Integer.parseInt(puntos.trim());
            System.out.println("Puntuación leída");
            
            InetAddress clienteIP = paqRecibido.getAddress();
            int puerto = paqRecibido.getPort();
            
            String resultado;
            
            for (int i=1 ; i<=t; i++) {
                suma += rnd.nextInt(6)+1;
                if(suma>=p){
                    resultado = "El jugador ha llegado a la puntuación deseada en "+i+" tiradas";
                    enviado = resultado.getBytes();
                    DatagramPacket paqEnviado = new DatagramPacket(enviado, enviado.length, clienteIP, puerto);
                    servidor.send(paqEnviado);
                    break;
                }
            }
            
            if(suma<p){
                resultado = "El jugador no ha llegado a la puntuación establecida";
                enviado = resultado.getBytes();
                DatagramPacket paqEnviado = new DatagramPacket(enviado, enviado.length, clienteIP, puerto);
                servidor.send(paqEnviado);
            }
        } catch (Exception e) {
        }
    }
}
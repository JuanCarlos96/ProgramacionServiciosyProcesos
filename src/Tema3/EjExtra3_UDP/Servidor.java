package Tema3.EjExtra3_UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Arrays;

public class Servidor {
    public static void main(String[] args) {
        try {
            DatagramSocket servidor = new DatagramSocket(49500);
            byte[] recibido = new byte[1024];
            byte[] enviado = new byte[1024];
            
            System.out.println("Esperando datagrama...");
            DatagramPacket paqRecibido = new DatagramPacket(recibido, recibido.length);
            servidor.receive(paqRecibido);
            InetAddress clienteIP = paqRecibido.getAddress();
            int puerto = paqRecibido.getPort();
            String tamanio = new String(paqRecibido.getData());
            System.out.println("Tamaño recibido");
            
            int size = Integer.parseInt(tamanio.trim());
            String[] vectorCadenas = new String[size];
            
            for(int i=0; i<size; i++){
                servidor.receive(paqRecibido);
                String valor = new String(paqRecibido.getData());
                vectorCadenas[i] = valor.trim();
            }
            
            System.out.println("Vector leído");
            
            int[] vectorEnteros = new int[size];
            for (int i=0; i<size; i++) {
                vectorEnteros[i] = Integer.parseInt(vectorCadenas[i]);
            }
            
            Arrays.sort(vectorEnteros);
            
            System.out.println("Vector ordenado");
            
            for(int i:vectorEnteros){
                String num = Integer.toString(i);
                enviado = num.getBytes();
                DatagramPacket paqEnviado = new DatagramPacket(enviado, enviado.length, clienteIP, puerto);
                servidor.send(paqEnviado);
            }
            
            System.out.println("Vector enviado");
            
            servidor.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
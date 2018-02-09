package Tema3.EjExtra3_UDP;

import java.net.*;
import java.util.Scanner;
import java.util.Random;

public class Cliente {
    public static void main(String[] args) {
        try {
            Scanner teclado = new Scanner(System.in);
            Random rnd = new Random();
            DatagramSocket cliente = new DatagramSocket();
            byte[] enviado = new byte[1024];
            byte[] recibido = new byte[1024];
            
            InetAddress servidorIP = InetAddress.getLocalHost();
            System.out.print("Introduce tamaño: ");
            String tamanio = teclado.nextLine();
            
            enviado = tamanio.getBytes();
            DatagramPacket paqEnviado = new DatagramPacket(enviado, enviado.length, servidorIP, 49500);
            cliente.send(paqEnviado);
            System.out.println("Tamaño enviado");
            
            System.out.print("Introduce el mínimo valor a generar: ");
            int min = Integer.parseInt(teclado.nextLine());
            
            System.out.print("Introduce el máximo valor a generar: ");
            int max = Integer.parseInt(teclado.nextLine());
            
            String[] vector = new String[Integer.parseInt(tamanio)];
            
            for(int i=0; i<Integer.parseInt(tamanio); i++) {
                vector[i] = Integer.toString(rnd.nextInt((max-min)+1)+min);
                enviado = vector[i].getBytes();
                paqEnviado = new DatagramPacket(enviado, enviado.length, servidorIP, 49500);
                cliente.send(paqEnviado);
            }
            
            System.out.println("Vector enviado");
            
            DatagramPacket paqRecibido = new DatagramPacket(recibido, recibido.length);
            for(int i=0; i<Integer.parseInt(tamanio); i++){
                cliente.receive(paqRecibido);
                String resultado = new String(paqRecibido.getData());
                System.out.print(resultado.trim()+" ");
            }
            
            cliente.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
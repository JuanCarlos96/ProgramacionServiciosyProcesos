package Tema3.EjExtra2_UDP;

import java.net.*;

public class Servidor {
    public static void main(String[] args) {
        try{
            DatagramSocket servidor = new DatagramSocket(49500);
            byte[] recibido = new byte[1024];
            byte[] enviado = new byte[1024];
            
            System.out.println("Esperando datagrama...");
            DatagramPacket paqRecibido = new DatagramPacket(recibido, recibido.length);
            servidor.receive(paqRecibido);
            String mensaje = new String(paqRecibido.getData());
            System.out.println("Datagrama recibido");
            
            InetAddress clienteIP = paqRecibido.getAddress();
            int puerto = paqRecibido.getPort();
            
            int num = Integer.parseInt(mensaje.trim());
            boolean esPrimo = nPrimo(num);
            String resultado;
            
            if(esPrimo)
                resultado = "El número introducido es primo";
            else
                resultado = "El número introducido no es primo";
            
            enviado = resultado.getBytes();
            DatagramPacket paqEnviado = new DatagramPacket(enviado, enviado.length, clienteIP, puerto);
            servidor.send(paqEnviado);
            System.out.println("Resultado enviado");
            
            servidor.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    private static boolean nPrimo(int numero){
        if(numero==2 || numero==1) return true;
        
        for(int i=2; i<numero; i++){
            if(numero%i==0){
                return false;
            }
        }
        
        return true;
    }
}
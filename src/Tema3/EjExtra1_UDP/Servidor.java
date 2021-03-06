package Tema3.EjExtra1_UDP;

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
            String nFibo = Integer.toString(nFibonacci(num));
            enviado = nFibo.getBytes();
            DatagramPacket paqEnviado = new DatagramPacket(enviado, enviado.length, clienteIP, puerto);
            servidor.send(paqEnviado);
            System.out.println("Resultado enviado");
            
            servidor.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    private static int nFibonacci(int ntermino){
        int n=1, n1=1, n2=1;
        
        for(int i=2; i<ntermino; i++){
            n=n1+n2;
            n1=n2;
            n2=n;
        }
        
        return n;
    }
}
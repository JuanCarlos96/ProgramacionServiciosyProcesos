package Tema3.EjExtra5_UDP;

import java.net.*;
import java.util.Random;

public class Servidor {
    public static void main(String[] args) {
        try {
            Random rnd = new Random();
            DatagramSocket servidor = new DatagramSocket(49500);
            byte[] recibido = new byte[1024];
            byte[] enviado = new byte[1024];
            int suma10=0, seis=0, totalseis=0, sumatotal=0, dado;
            
            System.out.println("Esperando datagrama...");
            DatagramPacket paqRecibido = new DatagramPacket(recibido, recibido.length);
            servidor.receive(paqRecibido);
            String tiradas = new String(paqRecibido.getData());
            int t = Integer.parseInt(tiradas.trim());
            System.out.println("Tiradas leídas");
            
            InetAddress clienteIP = paqRecibido.getAddress();
            int puerto = paqRecibido.getPort();
            
            String resultado;
            
            for (int i=0; i<t; i++) {
                dado=rnd.nextInt(6)+1;
                
                sumatotal+=dado;
                
                if(dado==10) suma10++;
                
                if(dado==6){
                    seis++;
                    if(seis>totalseis){
                        totalseis=seis;
                    }
                }else{
                    seis=0;
                }
            }
            
            resultado = "La suma total es: "+sumatotal+"\nVeces que ha salido 10: "+suma10+"\nVeces consecutivas que ha salido 6: "+totalseis;
            enviado = resultado.getBytes();
            DatagramPacket paqEnviado = new DatagramPacket(enviado, enviado.length, clienteIP, puerto);
            servidor.send(paqEnviado);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
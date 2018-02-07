package Tema3.EjExtra6_TCP;

import java.net.*;
import java.io.*;

public class Servidor {
    public static void main(String[] args) {
        try{
            ServerSocket servidor = new ServerSocket(49500);
            Socket cliente;
            
            System.out.println("Esperando cliente...");
            cliente = servidor.accept();
            System.out.println("Cliente conectado");
            
            BufferedReader br = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
            int[] ip = new int[4];
            
            for(int i=0; i<4; i++){
                ip[i] = Integer.parseInt(br.readLine());
            }
            
            PrintWriter pw = new PrintWriter(cliente.getOutputStream(), true);
            
            if(ip[0]<=127){
                pw.println("La IP es de clase A");
            }else if(ip[0]>=128 && ip[0]<=191){
                pw.println("La IP es de clase B");
            }else if(ip[0]>=192 && ip[0]<=223){
                pw.println("La IP es de clase C");
            }else{
                pw.println("La IP es de otra clase");
            }
            
            pw.close();
            br.close();
            cliente.close();
            servidor.close();
        }catch(IOException ioe){
            ioe.printStackTrace();
        }catch(NumberFormatException nfe){
            System.exit(0);
        }
    }
}
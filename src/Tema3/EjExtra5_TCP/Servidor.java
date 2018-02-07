package Tema3.EjExtra5_TCP;

import java.net.*;
import java.io.*;
import java.util.Random;

public class Servidor {
    public static void main(String[] args) {
        try {
            Random rnd = new Random();
            ServerSocket servidor = new ServerSocket(49500);
            Socket cliente;
            int suma10=0, seis=0, totalseis=0, sumatotal=0, dado;
            
            System.out.println("Esperando cliente...");
            cliente = servidor.accept();
            System.out.println("Cliente conectado");
            
            BufferedReader br = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
            int tiradas = Integer.parseInt(br.readLine());
            System.out.println("Tiradas leídas");
            
            for (int i=0; i<tiradas; i++) {
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
            
            PrintWriter pw = new PrintWriter(cliente.getOutputStream(), true);
            pw.println(sumatotal);
            pw.println(suma10);
            pw.println(totalseis);
            
            pw.close();
            br.close();
            cliente.close();
            servidor.close();
        } catch (Exception e) {
            System.out.println("Error");
        }
    }
}
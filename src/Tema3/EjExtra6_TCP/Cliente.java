package Tema3.EjExtra6_TCP;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        try{
            Scanner teclado = new Scanner(System.in);
            Socket servidor = new Socket("localhost", 49500);
            
            System.out.print("Introduzca dirección IP: ");
            String[] cadenaIP = teclado.nextLine().split("\\.");
            
            int[] ip = new int[4];
            
            for(int i=0; i<cadenaIP.length; i++){
                ip[i] = Integer.parseInt(cadenaIP[i]);
            }
            
            PrintWriter pw = new PrintWriter(servidor.getOutputStream(), true);
            
            if(ip[0]<0 || ip[0]>255 || ip[1]<0 || ip[1]>255 || ip[2]<0 || ip[2]>255 || ip[3]<0 || ip[3]>255){
                System.out.println("Formato no válido");
            }else{
                for(int i=0; i<4; i++){
                    pw.println(ip[i]);
                }
                System.out.println("Dirección IP enviada");
                
                BufferedReader br = new BufferedReader(new InputStreamReader(servidor.getInputStream()));
                System.out.println(br.readLine());

                br.close();
            }
            pw.close();
            servidor.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
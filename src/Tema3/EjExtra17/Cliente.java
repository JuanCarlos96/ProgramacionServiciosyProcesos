package Tema3.EjExtra17;

import java.io.*;
import java.net.Socket;
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
            
            ObjectOutputStream oos = new ObjectOutputStream(servidor.getOutputStream());
            
            if(ip[0]<0 || ip[0]>255 || ip[1]<0 || ip[1]>255 || ip[2]<0 || ip[2]>255 || ip[3]<0 || ip[3]>255){
                System.out.println("Formato no válido");
            }else{
                oos.writeObject(new DireccionIP(ip[0], ip[1], ip[2], ip[3]));
                System.out.println("Dirección IP enviada");
                
                ObjectInputStream ois = new ObjectInputStream(servidor.getInputStream());
                TipoDireccionIP tipoip = (TipoDireccionIP) ois.readObject();
                
                System.out.println("La IP "+tipoip.getIp()+" es de tipo "+tipoip.getTipo());

                ois.close();
            }
            
            oos.close();
            servidor.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
package Tema3.Ejemplo1;

import java.net.*;
import java.util.Scanner;

public class NewMain {
    private static void pruebaMetodos(InetAddress dir) {
        System.out.println("\tMetodo getByName(): " + dir);
        InetAddress dir2;
        try {
            dir2 = InetAddress.getLocalHost();
            System.out.println("\tMetodo getLocalHost(): " + dir2);
        } catch (UnknownHostException e) {e.printStackTrace();}
        //USAMOS METODOS DE LA CLASE
        System.out.println("\tMetodo getHostName(): "+dir.getHostName());
        System.out.println("\tMetodo getHostAddress(): "+dir.getHostAddress());
        System.out.println("\tMetodo toString(): "+dir.toString());
        System.out.println("\tMetodo getCanonicalHostName(): "+dir.getCanonicalHostName());
        try{
            System.out.println("\tDIRECCIONES IP PARA: "+dir.getHostName());
            InetAddress[] direcciones = InetAddress.getAllByName(dir.getHostName());
            for(int i = 0; i < direcciones.length; i++){
                System.out.println("\t\t"+direcciones[i].toString());
            }
        }catch(UnknownHostException uhe){
            uhe.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String direccion;
        System.out.print("Introduzca dirección IP o nombre de equipo: ");
        direccion = teclado.next();
        
        try {
            pruebaMetodos(InetAddress.getByName(direccion));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
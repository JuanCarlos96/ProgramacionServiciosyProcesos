package Tema3.EjExtra16;

import java.io.*;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        try {
            Scanner teclado = new Scanner(System.in);
            Socket servidor = new Socket("localhost",49500);
            
            PrintWriter pw = new PrintWriter(servidor.getOutputStream(), true);
            
            System.out.print("Introduce tiradas: ");
            int tiradas = Integer.parseInt(teclado.nextLine());
            pw.println(tiradas);
            
            ObjectInputStream ois = new ObjectInputStream(servidor.getInputStream());
            Resultado resultado = (Resultado) ois.readObject();
            
            System.out.println("La suma total es: "+resultado.getSumatotal());
            System.out.println("Veces que ha salido 10: "+resultado.getTotaldiez());
            System.out.println("Veces consecutivas que ha salido doble 6: "+resultado.getDobleseis());
            
            ois.close();
            pw.close();
            servidor.close();
        } catch (Exception e) {
            System.out.println("Error");
        }
    }
}
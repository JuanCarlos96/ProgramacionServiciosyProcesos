package Tema3.EjExtra15;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        try {
            Scanner teclado = new Scanner(System.in);
            Socket servidor = new Socket("localhost", 49500);
            ObjectOutputStream oos = new ObjectOutputStream(servidor.getOutputStream());
            
            System.out.print("Introduzca puntuación: ");
            int puntuacion = Integer.parseInt(teclado.nextLine());
            
            System.out.print("Introduzca tiradas: ");
            int tiradas = Integer.parseInt(teclado.nextLine());
            
            Jugador jugador = new Jugador(puntuacion, tiradas);
            oos.writeObject(jugador);
            
            ObjectInputStream ois = new ObjectInputStream(servidor.getInputStream());
            Resultado resultado = (Resultado) ois.readObject();
            
            System.out.println("La puntuación a la que ha llegado ha sido "+resultado.getPuntuacion()+" en "+resultado.getTiradas()+" tiradas");
            
            oos.close();
            ois.close();
            servidor.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
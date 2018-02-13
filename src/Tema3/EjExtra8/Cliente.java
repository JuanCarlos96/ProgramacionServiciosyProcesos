package Tema3.EjExtra8;

import java.util.Scanner;
import java.io.*;
import java.net.Socket;

public class Cliente {
    public static void main(String[] args) {
        try {
            Socket servidor = new Socket("localhost", 49500);
            Scanner teclado = new Scanner(System.in);
            
            System.out.print("Introduce nombre del empleado: ");
            String nombre = teclado.nextLine();
            System.out.print("Introduce apellidos del empleado: ");
            String apellidos = teclado.nextLine();
            System.out.print("Introduce iddep del empleado: ");
            String iddep = teclado.nextLine();
            System.out.print("Introduce salario del empleado: ");
            float salario = Float.parseFloat(teclado.nextLine());
            System.out.print("Introduce antigüedad del empleado: ");
            int antiguedad = Integer.parseInt(teclado.nextLine());
            
            Empleado empleado = new Empleado(nombre, apellidos, iddep, salario, antiguedad);
            ObjectOutputStream oos = new ObjectOutputStream(servidor.getOutputStream());
            oos.writeObject(empleado);
            
            ObjectInputStream ois = new ObjectInputStream(servidor.getInputStream());
            empleado = (Empleado) ois.readObject();
            
            System.out.println("Nombre: "+empleado.getNombre());
            System.out.println("Apellidos: "+empleado.getApellidos());
            System.out.println("IdDep: "+empleado.getIddep());
            System.out.println("Salario: "+empleado.getSalario());
            System.out.println("Antigüedad: "+empleado.getAntiguedad());
            
            ois.close();
            oos.close();
            servidor.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
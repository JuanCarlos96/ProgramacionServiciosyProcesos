package Tema3.EjExtra10;

import java.util.Scanner;
import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class Cliente {
    public static void main(String[] args) {
        try {
            Socket servidor = new Socket("localhost", 49500);
            Scanner teclado = new Scanner(System.in);
            ArrayList<Empleado> empleados = new ArrayList();
            
            System.out.print("Introduce el número de empleados: ");
            int n = Integer.parseInt(teclado.nextLine());
            
            for (int i=0; i<n; i++) {
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
                System.out.println("");

                Empleado empleado = new Empleado(nombre, apellidos, iddep, salario, antiguedad);
                empleados.add(empleado);
            }
            
            ObjectOutputStream oos = new ObjectOutputStream(servidor.getOutputStream());
            oos.writeObject(empleados);
            
            ObjectInputStream ois = new ObjectInputStream(servidor.getInputStream());
            ArrayList departamentos = (ArrayList) ois.readObject();
            
            for(Object obj:departamentos){
                Departamento d = (Departamento) obj;
                System.out.println("\nDepartamento: "+d.getIddep());
                System.out.println("Media: "+d.getMedia());
            }
            
            ois.close();
            oos.close();
            servidor.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
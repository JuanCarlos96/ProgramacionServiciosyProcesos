package Tema3.EjExtra10_UDP;

import java.util.Scanner;
import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class Cliente {
    public static void main(String[] args) {
        try {
            DatagramSocket cliente = new DatagramSocket();
            byte[] enviado = new byte[1024];
            byte[] recibido = new byte[1024];
            InetAddress servidorIP = InetAddress.getLocalHost();
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
            
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(empleados);
            enviado = baos.toByteArray();
            DatagramPacket paqEnviado = new DatagramPacket(enviado, enviado.length, servidorIP, 49500);
            cliente.send(paqEnviado);
            System.out.println("Empleados enviados");
            
            DatagramPacket paqRecibido = new DatagramPacket(recibido, recibido.length);
            cliente.receive(paqRecibido);
            ByteArrayInputStream bais = new ByteArrayInputStream(recibido);
            ObjectInputStream ois = new ObjectInputStream(bais);
            ArrayList departamentos = (ArrayList) ois.readObject();
            
            for(Object obj:departamentos){
                Departamento d = (Departamento) obj;
                System.out.println("\nDepartamento: "+d.getIddep());
                System.out.println("Media: "+d.getMedia());
            }
            
            ois.close();
            oos.close();
            cliente.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
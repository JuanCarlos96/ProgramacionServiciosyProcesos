package Tema3.EjExtra8_UDP;

import java.util.Scanner;
import java.io.*;
import java.net.*;

public class Cliente {
    public static void main(String[] args) {
        try {
            DatagramSocket cliente = new DatagramSocket();
            byte[] enviado = new byte[1024];
            byte[] recibido = new byte[1024];
            InetAddress servidorIP = InetAddress.getLocalHost();
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
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(empleado);
            enviado = baos.toByteArray();
            DatagramPacket paqEnviado = new DatagramPacket(enviado, enviado.length, servidorIP, 49500);
            cliente.send(paqEnviado);
            System.out.println("Empleado enviado");
            
            DatagramPacket paqRecibido = new DatagramPacket(recibido, recibido.length);
            cliente.receive(paqRecibido);
            ByteArrayInputStream bais = new ByteArrayInputStream(recibido);
            ObjectInputStream ois = new ObjectInputStream(bais);
            empleado = (Empleado) ois.readObject();
            
            System.out.println("Nombre: "+empleado.getNombre());
            System.out.println("Apellidos: "+empleado.getApellidos());
            System.out.println("IdDep: "+empleado.getIddep());
            System.out.println("Salario: "+empleado.getSalario());
            System.out.println("Antigüedad: "+empleado.getAntiguedad());
            
            ois.close();
            oos.close();
            cliente.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
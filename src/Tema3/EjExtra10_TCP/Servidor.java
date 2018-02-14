package Tema3.EjExtra10_TCP;

import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class Servidor {
    public static void main(String[] args) {
        try {
            ServerSocket servidor = new ServerSocket(49500);
            Socket cliente;
            ArrayList<Departamento> departamentos = new ArrayList();
            
            System.out.println("Esperando cliente...");
            cliente = servidor.accept();
            System.out.println("Cliente conectado");
            
            ObjectInputStream ois = new ObjectInputStream(cliente.getInputStream());
            ArrayList empleados = (ArrayList) ois.readObject();
            
            for(Object obj:empleados){
                Empleado e = (Empleado) obj;
                boolean existe = false;
                for(Departamento d:departamentos){
                    if(e.getIddep().equals(d.getIddep())){
                        existe = true;
                    }
                }
                if(!existe){
                    departamentos.add(new Departamento(e.getIddep()));
                }
            }
            
            float[] medias = new float[departamentos.size()];
            int[] contadores = new int[departamentos.size()];
            
            for(int i=0; i<departamentos.size(); i++){
                medias[i]=0;
                contadores[i]=0;
            }
            
            for(Object obj:empleados){
                Empleado e = (Empleado) obj;
                for(Departamento d:departamentos){
                    if(e.getIddep().equals(d.getIddep())){
                        int index = departamentos.indexOf(d);
                        medias[index]+=e.getSalario();
                        contadores[index]+=1;
                    }
                }
            }
            
            for(int i=0; i<departamentos.size(); i++){
                departamentos.get(i).setMedia(medias[i]/contadores[i]);
            }
            
            ObjectOutputStream oos = new ObjectOutputStream(cliente.getOutputStream());
            oos.writeObject(departamentos);
            
            oos.close();
            ois.close();
            cliente.close();
            servidor.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
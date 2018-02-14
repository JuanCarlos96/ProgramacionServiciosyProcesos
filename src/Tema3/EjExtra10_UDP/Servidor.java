package Tema3.EjExtra10_UDP;

import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class Servidor {
    public static void main(String[] args) {
        try {
            DatagramSocket servidor = new DatagramSocket(49500);
            byte[] recibido = new byte[1024];
            byte[] enviado = new byte[1024];
            ArrayList<Departamento> departamentos = new ArrayList();
            
            System.out.println("Esperando datagrama...");
            DatagramPacket paqRecibido = new DatagramPacket(recibido, recibido.length);
            servidor.receive(paqRecibido);
            ByteArrayInputStream bais = new ByteArrayInputStream(recibido);
            ObjectInputStream ois = new ObjectInputStream(bais);
            ArrayList empleados = (ArrayList) ois.readObject();
            System.out.println("Empleados leídos");
            
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
            
            InetAddress clienteIP = paqRecibido.getAddress();
            int puerto = paqRecibido.getPort();
            
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(departamentos);
            enviado = baos.toByteArray();
            DatagramPacket paqEnviado = new DatagramPacket(enviado, enviado.length, clienteIP, puerto);
            servidor.send(paqEnviado);
            
            oos.close();
            ois.close();
            servidor.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
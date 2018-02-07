package Tema3.Ejercicio4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Cliente2 {
    public static void main(String[] args) {
        try{
            //FLUJO PARA ENTRADA ESTANDAR
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            DatagramSocket clientSocket = new DatagramSocket(); //socket cliente
            byte[] enviados = new byte[1024];
            byte[] recibidos = new byte[1024];
            //DATOS DEL SERVIDOR al que enviar mensaje
            InetAddress IPServidor = InetAddress.getLocalHost(); //localhost
            int puerto = 9876; //puerto por el que escucha
            //INTRODUCIR DATOS POR TECLADO
            System.out.print("Introduce mensaje: ");
            String cadena = in.readLine();
            enviados = cadena.getBytes();
            //ENVIANDO DATAGRAMA AL SERVIDOR
            System.out.println("Enviando "+enviados.length+" bytes al servidor");
            DatagramPacket envio = new DatagramPacket(enviados, enviados.length, IPServidor, puerto);
            clientSocket.send(envio);
            //RECIBIENDO DATAGRAMA DEL SERVIDOR
            DatagramPacket recibo = new DatagramPacket(recibidos, recibidos.length);
            System.out.println("Esperando datagrama...");
            clientSocket.setSoTimeout(5000);
            clientSocket.receive(recibo);
            String mayuscula = new String(recibo.getData());
            //OBTENIENDO INFORMACIÓN DEL DATAGRAMA
            InetAddress IPOrigen = recibo.getAddress();
            int puertoOrigen = recibo.getPort();
            System.out.println("\tProcedente de: " + IPOrigen + ":" + puertoOrigen);
            System.out.println("\tDatos: " + mayuscula.trim());
            clientSocket.close(); //cerrar socket
        }catch(IOException e){
            System.out.println("Paquete perdido");
        }
    }
}
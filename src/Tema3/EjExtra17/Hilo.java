package Tema3.EjExtra17;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Hilo extends Thread{
    private Socket c;
    private ObjectOutputStream oos;
    private ObjectInputStream ois;

    public Hilo(Socket c) {
        this.c = c;
        
        try {
            oos = new ObjectOutputStream(c.getOutputStream());
            ois = new ObjectInputStream(c.getInputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            DireccionIP ip = (DireccionIP) ois.readObject();
            int octeto1 = ip.getOcteto1();
            
            if(octeto1<=127){
                oos.writeObject(new TipoDireccionIP(ip.toString(), 'A'));
            }else if(octeto1>=128 && octeto1<=191){
                oos.writeObject(new TipoDireccionIP(ip.toString(), 'B'));
            }else if(octeto1>=192 && octeto1<=223){
                oos.writeObject(new TipoDireccionIP(ip.toString(), 'C'));
            }else{
                /*
                COMO HAY QUE PASARLE UN OBJETO DE LA CLASE TipoDireccionIP Y UN PARÁMETRO ES UN CARÁCTER,
                MANDO 'X' QUERIENDO DECIR QUE NO ES DE CLASE A, B Ó C
                */
                oos.writeObject(new TipoDireccionIP(ip.toString(), 'X'));
            }
            
            oos.close();
            ois.close();
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
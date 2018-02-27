package Tema3.EjExtra16;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class Hilo extends Thread{
    private Socket c;
    private Random rnd = new Random();
    private ObjectOutputStream oos;
    private BufferedReader br;

    public Hilo(Socket c) {
        this.c = c;
        
        try {
            oos = new ObjectOutputStream(c.getOutputStream());
            br = new BufferedReader(new InputStreamReader(c.getInputStream()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            Random rnd = new Random();
            int suma10=0, seis=0, totalseis=0, sumatotal=0, dado, dado2;
            
            int tiradas = Integer.parseInt(br.readLine());
            System.out.println("Tiradas leídas");
            
            for (int i=0; i<tiradas; i++) {
                dado=rnd.nextInt(6)+1;
                dado2=rnd.nextInt(6)+1;
                
                //System.out.println(dado+" "+dado2);
                
                sumatotal+=dado+dado2;
                
                if(dado+dado2==10) suma10++;
                
                if(dado==6 & dado2==6){
                    seis++;
                    if(seis>totalseis){
                        totalseis=seis;
                    }
                }else{
                    seis=0;
                }
            }
            
            oos.writeObject(new Resultado(suma10, totalseis, sumatotal));
            
            oos.close();
            br.close();
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
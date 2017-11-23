package Tema2.EjExtra4;

import java.util.Random;

public class ObreraEj4 extends Thread{
    private int dado1, dado2, dobleseis = 0, diez = 0, cont = 0;
    private long sumatotal = 0;
    private Random rnd = new Random();
    
    public ObreraEj4(){
        
    }
    
    public void run(){
        while(!isInterrupted()){
            dado1 = rnd.nextInt(6)+1;
            dado2 = rnd.nextInt(6)+1;
            //System.out.println(dado1+" "+dado2);
            
            sumatotal += dado1 + dado2;
            
            if((dado1+dado2)==10)
                diez++;
            
            if(dado1==6 && dado2==6)
                cont++;
            else
                cont = 0;
            
            if(cont>dobleseis)
                dobleseis = cont;
            
            try {
                sleep(100);
            } catch (InterruptedException e) {
            }
        }
    }

    public long getSumatotal() {
        return sumatotal;
    }

    public int getDobleseis() {
        return dobleseis;
    }

    public int getDiez() {
        return diez;
    }
}
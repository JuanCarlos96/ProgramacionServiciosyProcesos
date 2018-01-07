package Tema2.EjExtra5;

public class Primo {
    private int primo;
    private boolean disponible = false;
    
    public synchronized void put(int primo){
        while(disponible){
            try{
                wait();
            }catch(InterruptedException ie) {}
        }
        this.primo = primo;
        disponible = true;
        notifyAll();
    }
    
    public synchronized int get(){
        while(!disponible){
            try {
                wait();
            } catch (InterruptedException ie) {}
        }
        disponible = false;
        notifyAll();
        return this.primo;
    } 
}
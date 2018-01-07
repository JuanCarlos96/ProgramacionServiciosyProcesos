package Tema2.EjExtra6;

public class Fibonacci {
    private int fibo;
    private boolean disponible = false;
    
    public synchronized void put(int fibo){
        while(disponible){
            try{
                wait();
            }catch(InterruptedException ie) {}
        }
        this.fibo = fibo;
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
        return this.fibo;
    }

    public boolean isDisponible() {
        return disponible;
    }
}
package Tema2.EjExtra6;


public class ConsumeFibo extends Thread{
    private Fibonacci fibonacci;
    private int id;

    public ConsumeFibo(Fibonacci fibonacci, int id) {
        this.fibonacci = fibonacci;
        this.id = id;
    }

    @Override
    public void run() {
        int fibo;
        while(this.fibonacci.isDisponible()){
            fibo = this.fibonacci.get();
            System.out.println("Consumidor "+this.id+" consume: "+fibo);
        }
    }
}
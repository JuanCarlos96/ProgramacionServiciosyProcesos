package Tema2.EjExtra6;


public class ConsumeFibo extends Thread{
    private Fibonacci fibonacci;
    private int id,n;

    public ConsumeFibo(Fibonacci fibonacci, int id, int n) {
        this.fibonacci = fibonacci;
        this.id = id;
        this.n = n;
    }

    @Override
    public void run() {
        int fibo;
        for(int i=0; i<n; i++){
            fibo = this.fibonacci.get();
            System.out.println("Consumidor "+this.id+" consume: "+fibo);
        }
    }
}
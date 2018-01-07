package Tema2.EjExtra6;

public class ProduceFibo extends Thread{
    private Fibonacci fibonacci;
    private int id,n,suma,num1 = 0,num2 = 1;

    public ProduceFibo(Fibonacci fibonacci, int id, int n) {
        this.fibonacci = fibonacci;
        this.id = id;
        this.n = n;
    }

    @Override
    public void run() {
        if(n>=1){
            System.out.println("Productor "+this.id+" produce: "+num1);
            this.fibonacci.put(num1);
        }
        
        if(n>=2){
            System.out.println("Productor "+this.id+" produce: "+num2);
            this.fibonacci.put(num2);
        }
        
        for(int i=3; i<=n; i++){
            suma = num1 + num2;
            num1 = num2;
            num2 = suma;
            System.out.println("Productor "+this.id+" produce: "+suma);
            this.fibonacci.put(suma);
        }
    }
}
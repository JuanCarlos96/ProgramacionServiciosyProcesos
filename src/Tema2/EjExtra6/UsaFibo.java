package Tema2.EjExtra6;

import java.util.Scanner;

public class UsaFibo {
    public static void main(String[] args) {
        Fibonacci fibo = new Fibonacci();
        int n;
        Scanner teclado = new Scanner(System.in);
        System.out.print("Número de términos a calcular: ");
        n = teclado.nextInt();
        
        ProduceFibo productor = new ProduceFibo(fibo, 1, n);
        ConsumeFibo consumidor = new ConsumeFibo(fibo, 1, n);
        
        productor.start();
        consumidor.start();
        
        try {
            consumidor.join();
            productor.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
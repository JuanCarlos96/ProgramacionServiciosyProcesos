package Tema2.EjExtra2;

import java.util.Scanner;

public class UsaObreraEj2 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int cantidad, inicio;
        
        System.out.print("Introduce la cantidad de números a calcular: ");
        cantidad = teclado.nextInt();
        System.out.print("Introduce el número desde que empezará a calcular: ");
        inicio = teclado.nextInt();
        
        ObreraEj2 obrera = new ObreraEj2(cantidad, inicio);
        obrera.start();
        
        for(int i=0; i<cantidad; i++){
            if(inicio%5==0){
                System.out.println(inicio);
            }
            inicio++;
        }
        
        while(obrera.isAlive()){
            Thread.yield();
        }
        
        System.out.println("La suma de los números primos es "+obrera.getSuma());
    }
}
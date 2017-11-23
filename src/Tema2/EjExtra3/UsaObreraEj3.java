package Tema2.EjExtra3;

import java.util.Scanner;

public class UsaObreraEj3 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int cantidad, inicio;
        
        System.out.print("Introduce la cantidad de números a calcular: ");
        cantidad = teclado.nextInt();
        System.out.print("Introduce el número desde que empezará a calcular: ");
        inicio = teclado.nextInt();
        
        ObreraEj3 obrera = new ObreraEj3(cantidad, inicio);
        obrera.start();
        
        for(int i=0; i<cantidad; i++){
            if(inicio%5==0){
                System.out.println(inicio);
            }
            inicio++;
        }
        
        try {
            obrera.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("La suma de los números primos es "+obrera.getSuma());
    }
}
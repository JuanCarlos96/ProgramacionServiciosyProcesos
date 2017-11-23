package Tema2.EjExtra4;

import java.util.*;

public class UsaObreraEj4 {
    public static void main(String[] args) {
        ObreraEj4 obrera = new ObreraEj4();
        obrera.start();
        Scanner teclado = new Scanner(System.in);
        Random rnd = new Random();
        ArrayList<Integer> numeros;
        int opcion, cantidad, max, min;
        
        while(true){
            System.out.println("\n1. Calcular media");
            System.out.println("2. Calcular máximo");
            System.out.println("3. Calcular mínimo");
            System.out.println("4. Finalizar obrera");
            System.out.print("Introduzca una opción: ");
            opcion = teclado.nextInt();
            
            switch(opcion){
                case 1:
                    System.out.print("\nIntroduzca la cantidad de números de los que quiera calcular la media: ");
                    cantidad = teclado.nextInt();
                    System.out.print("Introduzca el mínimo de los números que se van a generar: ");
                    min = teclado.nextInt();
                    System.out.print("Introduzca el máximo de los números que se van a generar: ");
                    max = teclado.nextInt();
                    
                    numeros = new ArrayList();
                    int suma = 0;
                    double media;
                    
                    for(int i=0; i<cantidad; i++)
                        numeros.add(rnd.nextInt((max-min)+1)+min);
                    
                    for(Integer n:numeros)
                        suma+=n;
                    
                    media = suma/cantidad;
                    
                    System.out.println("La media de los números generados es: "+media);
                    break;
                case 2:
                    System.out.print("\nIntroduzca la cantidad de números de los que quiera calcular el máximo: ");
                    cantidad = teclado.nextInt();
                    System.out.print("Introduzca el mínimo de los números que se van a generar: ");
                    min = teclado.nextInt();
                    System.out.print("Introduzca el máximo de los números que se van a generar: ");
                    max = teclado.nextInt();
                    
                    numeros = new ArrayList();
                    
                    for(int i=0; i<cantidad; i++)
                        numeros.add(rnd.nextInt((max-min)+1)+min);
                    
                    int max2 = numeros.get(0);
                    
                    for(int i=1; i<numeros.size(); i++)
                        if(numeros.get(i)>max2)
                            max2 = numeros.get(i);
                    
                    System.out.println("El máximo de los números generados es: "+max2);
                    break;
                case 3:
                    System.out.print("\nIntroduzca la cantidad de números de los que quiera calcular el mínimo: ");
                    cantidad = teclado.nextInt();
                    System.out.print("Introduzca el mínimo de los números que se van a generar: ");
                    min = teclado.nextInt();
                    System.out.print("Introduzca el máximo de los números que se van a generar: ");
                    max = teclado.nextInt();
                    
                    numeros = new ArrayList();
                    
                    for(int i=0; i<cantidad; i++)
                        numeros.add(rnd.nextInt((max-min)+1)+min);
                    
                    int min2 = numeros.get(0);
                    
                    for(int i=1; i<numeros.size(); i++)
                        if(numeros.get(i)<min2)
                            min2 = numeros.get(i);
                    
                    System.out.println("El mínimo de los números generados es: "+min2);
                    break;
                default:
                    obrera.interrupt();
                    System.out.println("\nLa suma total de las tiradas es: "+obrera.getSumatotal());
                    System.out.println("Las veces que los dos dados han sumado 10 han sido: "+obrera.getDiez());
                    System.out.println("Las veces seguidas que ha salido doble seis han sido: "+obrera.getDobleseis());
                    System.exit(0);
                    break;
            }
        }
    }
}
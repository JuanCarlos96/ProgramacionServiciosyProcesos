package Tema2.EjExtra5;


public class Main {
    public static void main(String[] args) {
        Primo primo = new Primo();
        ProducePrimo productor = new ProducePrimo(primo, 1);
        ConsumePrimo consumidor = new ConsumePrimo(primo, 1);
        
        productor.start();
        consumidor.start();
    }
}
package Tema2.EjExtra5;

public class ConsumePrimo extends Thread{
    private Primo primo;
    private int id;

    public ConsumePrimo(Primo primo, int id) {
        this.primo = primo;
        this.id = id;
    }

    @Override
    public void run() {
        int primo;
        for(int i=0; i<10; i++){
            primo = this.primo.get();
            System.out.println("Consumidor "+this.id+" consume: "+primo);
        }
    }
}
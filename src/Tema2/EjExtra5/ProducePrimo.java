package Tema2.EjExtra5;

public class ProducePrimo extends Thread{
    private Primo primo;
    private int id,esPrimo = 2,cont = 0;

    public ProducePrimo(Primo primo, int id) {
        this.primo = primo;
        this.id = id;
    }

    @Override
    public void run() {
        while(cont<10){
            boolean primo = true;
            for (int j=2; j<esPrimo; j++){
                if (esPrimo%j ==0){
                    primo = false;
                    break;
                }
            }
            if (primo){
                this.primo.put(esPrimo);
                System.out.println("Productor "+this.id+" produce: "+esPrimo);
                cont++;
            }
            esPrimo++;
            try{
                sleep(100);
            }catch(InterruptedException ie) {}
        }
    }
}
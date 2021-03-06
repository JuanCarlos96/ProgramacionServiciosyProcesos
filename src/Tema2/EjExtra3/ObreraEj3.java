package Tema2.EjExtra3;

public class ObreraEj3 extends Thread{
    private int suma, inicio, cantidad;

    public ObreraEj3(int cantidad, int inicio) {
        this.cantidad = cantidad;
        this.inicio = inicio;
    }
    
    public void run(){
        suma = 0;
        int n = this.cantidad;
        int cont = 0;
        int esPrimo = this.inicio;
        
        while(cont<n){
            boolean primo = true;
            for (int j=2; j<esPrimo; j++){
              if (esPrimo%j ==0){
                primo = false;
                break;
              }
            }
            if (primo){
                //System.out.println(esPrimo);
                suma+=esPrimo;
                cont++;
            } 
            esPrimo++;
        }
    }

    public int getSuma() {
        return suma;
    }
}
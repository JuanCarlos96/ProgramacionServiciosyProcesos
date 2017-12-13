package Tema2.Ejercicio10;

public class Cuenta {
    private int actual,max;
    
    public Cuenta(int actual, int max){
        this.actual = actual;
        this.max = max;
    }

    synchronized public void ingresar(int cantidad){
        System.out.println("Se va a ingresar: "+cantidad);
        if((this.getActual()+cantidad)>this.max){
            System.out.println("No se puede realizar la operación, el total es mayor que el máximo");
            System.exit(0);
        }else{
            this.actual+=cantidad;
            System.out.println("La operación se ha realizado correctamente, dinero actual: "+this.getActual());
        }
    }
    
    synchronized public void retirar(int cantidad){
        System.out.println("Se va a retirar: "+cantidad);
        if(cantidad>this.actual){
            System.out.println("No se puede realizar la operación, la cantidad es mayor que el saldo actual");
            System.exit(0);
        }else{
            this.actual-=cantidad;
            System.out.println("La operación se ha realizado correctamente, dinero actual: "+this.getActual());
        }
    }

    public int getActual() {
        return this.actual;
    }
}
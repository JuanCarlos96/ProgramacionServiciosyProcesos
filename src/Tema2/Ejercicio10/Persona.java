package Tema2.Ejercicio10;

public class Persona extends Thread{
    private Cuenta cuenta;
    private String nombre;
    
    public Persona(String nombre, Cuenta cuenta){
        this.nombre = nombre;
        this.cuenta = cuenta;
    }

    @Override
    public void run() {
        while(true){
            //INGRESAR
            System.out.println(this.nombre+" va a ingresar");
            this.cuenta.ingresar((int) (Math.random() * 500 + 1));
            try{
                sleep(500);
            }catch(InterruptedException ie){}
            
            System.out.println(this.nombre+" va a ingresar");
            this.cuenta.ingresar((int) (Math.random() * 500 + 1));
            try{
                sleep(500);
            }catch(InterruptedException ie){}
            
            //RETIRAR
            System.out.println(this.nombre+" va a retirar");
            this.cuenta.retirar((int) (Math.random() * 500 + 1));
            try{
                sleep(500);
            }catch(InterruptedException ie){}
            
            System.out.println(this.nombre+" va a retirar");
            this.cuenta.retirar((int) (Math.random() * 500 + 1));
            try{
                sleep(500);
            }catch(InterruptedException ie){}
        }
    }
}
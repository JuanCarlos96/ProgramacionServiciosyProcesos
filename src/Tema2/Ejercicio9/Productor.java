package Tema2.Ejercicio9;

public class Productor extends Thread {
    private Cola cola;

    public Productor(Cola c) {
        this.cola = c;
    }

    public void run() {
        for (int i=1; i<=6; i++) {
            if(i%2!=0){
                cola.put("PING");
            }else{
                cola.put("PONG");
            }

            try {
                sleep(100);
            } catch (InterruptedException e) { }
        }
    }
}

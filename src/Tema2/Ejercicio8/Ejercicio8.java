package Tema2.Ejercicio8;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ejercicio8 extends Applet implements ActionListener{
    private class HiloPrimos extends Thread{
        private int contador = 0,esPrimo = 2;
        
        public HiloPrimos(){};

        @Override
        public void run() {
            try{
                while(!isInterrupted()){
                    boolean primo = true;
                    for (int j=2; j<esPrimo; j++){
                        if (esPrimo%j ==0){
                            primo = false;
                            break;
                        }
                    }
                    if (primo){
                        System.out.println(esPrimo);
                        contador++;
                    }
                    esPrimo++;
                    sleep(50);
                }
            }catch(InterruptedException e){}
        }

        public int getContador() {
            return contador;
        }
    }
    
    private HiloPrimos hp;
    private Font fuente;
    private Button b1;
    private boolean parado = false;
    
    @Override
    public void init(){
        setBackground(Color.yellow);
        add(b1 = new Button("Finalizar hilo"));
        b1.addActionListener(this);
        fuente = new Font("Verdana",Font.BOLD,26);
    }

    @Override
    public void start(){
        hp = new HiloPrimos();
        hp.start();
    }

    @Override
    public void paint(Graphics g){
        g.clearRect(0,0,400,400);
        g.setFont(fuente);
        if(!parado){
            g.drawString("Calculando primos...",80,100);
        }else{
            g.drawString("Primos calculados :"+Integer.toString(hp.getContador()),80,100);
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1){
            if(hp!=null && hp.isAlive()){
                hp.interrupt();
                parado = true;
                repaint();
            }
        }
    }
    
}
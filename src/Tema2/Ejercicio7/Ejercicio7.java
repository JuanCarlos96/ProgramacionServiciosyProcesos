package Tema2.Ejercicio7;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;


public class Ejercicio7 extends Applet implements ActionListener{
    private class HiloContador extends Thread{
        private int contador;

        HiloContador(int contador){
                this.contador = contador;
        }

        @Override
        public void run(){
            while(!isInterrupted()){
                repaint();
                this.contador++;
                try{
                    this.sleep(500);
                }catch(InterruptedException ie){}
            }
        }

        public int getContador(){
            return this.contador;
        }
    }
    
    private HiloContador h1,h2;
    private Font fuente;
    private Button b1,b2;

    @Override
    public void init(){
        setBackground(Color.yellow);
        add(b1 = new Button("Finalizar hilo 1"));
        b1.addActionListener(this);
        add(b2 = new Button("Finalizar hilo 2"));
        b2.addActionListener(this);
        fuente = new Font("Verdana",Font.BOLD,26);
    }

    @Override
    public void start(){
        Random rnd = new Random();
        h1 = new HiloContador(rnd.nextInt(101));
        h2 = new HiloContador(rnd.nextInt(101));

        h1.start();
        h2.start();
    }

    @Override
    public void paint(Graphics g){
        g.clearRect(0,0,400,400);
        g.setFont(fuente);
        g.drawString("Hilo 1: "+Integer.toString(h1.getContador()),80,100);
        g.drawString("Hilo 2: "+Integer.toString(h2.getContador()),80,120);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1){
            if(!h1.isInterrupted())
                h1.interrupt();
        }

        if(e.getSource()==b2){
            if(!h1.isInterrupted())
                h2.interrupt();
        }
    }
    
}
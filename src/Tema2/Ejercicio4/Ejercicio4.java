package Tema2.Ejercicio4;

import java.applet.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class Ejercicio4 extends Applet implements ActionListener{
    private class HiloContador extends Thread{
        private int contador;
        private boolean parado;

        HiloContador(int contador){
                this.contador = contador;
        }

        public void run(){
            parado = false;
            while(parado==false){
                try{
                    this.sleep(500);
                }catch(Exception e){
                    e.printStackTrace();
                }
                repaint();
                this.contador++;
            }
        }

        public int getContador(){
            return this.contador;
        }

        public void setParado(boolean parado){
            this.parado = parado;
        }
    }
	
    private HiloContador h1,h2;
    private Font fuente;
    private Button b1,b2;

    public void init(){
        setBackground(Color.yellow);
        add(b1 = new Button("Finalizar hilo 1"));
        b1.addActionListener(this);
        add(b2 = new Button("Finalizar hilo 2"));
        b2.addActionListener(this);
        fuente = new Font("Verdana",Font.BOLD,26);
    }

    public void start(){
        Random rnd = new Random();
        h1 = new HiloContador(rnd.nextInt(101));
        h2 = new HiloContador(rnd.nextInt(101));

        h1.start();
        h2.start();
    }

    public void paint(Graphics g){
        g.clearRect(0,0,400,400);
        g.setFont(fuente);
        g.drawString("Hilo 1: "+Integer.toString(h1.getContador()),80,100);
        g.drawString("Hilo 2: "+Integer.toString(h2.getContador()),80,120);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            if(h1.isAlive()){
                h1.setParado(true);
            }
        }

        if(ae.getSource()==b2){
            if(h2.isAlive()){
                h2.setParado(true);
            }
        }
    }
}
package Tema2.Ejercicio6;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

public class Ejercicio6 extends Applet implements ActionListener{

    class HiloContador extends Thread{
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
    
    private HiloContador h1,h2,h3;
    private Font fuente;
    private Button finalizartodos,b1mas,b1menos,b1parar,b2mas,b2menos,b2parar,b3mas,b3menos,b3parar;

    public void init(){
        setBackground(Color.yellow);
        JPanel panel = new JPanel(new GridLayout(3, 2));
        add(panel);
        add(finalizartodos = new Button("Finalizar Todos"));
        finalizartodos.addActionListener(this);
        
        panel.add(b1mas = new Button("Prioridad hilo 1 +"));
        b1mas.addActionListener(this);
        panel.add(b1menos = new Button("Prioridad hilo 1 -"));
        b1menos.addActionListener(this);
        panel.add(b1parar = new Button("Parar hilo 1"));
        b1parar.addActionListener(this);
        
        panel.add(b2mas = new Button("Prioridad hilo 2 +"));
        b2mas.addActionListener(this);
        panel.add(b2menos = new Button("Prioridad hilo 2 -"));
        b2menos.addActionListener(this);
        panel.add(b2parar = new Button("Parar hilo 2"));
        b2parar.addActionListener(this);
        
        panel.add(b3mas = new Button("Prioridad hilo 3 +"));
        b3mas.addActionListener(this);
        panel.add(b3menos = new Button("Prioridad hilo 3 -"));
        b3menos.addActionListener(this);
        panel.add(b3parar = new Button("Parar hilo 3"));
        b3parar.addActionListener(this);
        fuente = new Font("Verdana",Font.BOLD,26);
    }

    public void start(){
        h1 = new HiloContador(1);
        h2 = new HiloContador(1);
        h3 = new HiloContador(1);

        h1.setPriority(Thread.NORM_PRIORITY);
        h1.start();
        h2.setPriority(Thread.NORM_PRIORITY);
        h2.start();
        h3.setPriority(Thread.NORM_PRIORITY);
        h3.start();
    }

    public void paint(Graphics g){
        g.clearRect(0,0,500,500);
        g.setFont(fuente);
        g.drawString("Hilo 1: "+Integer.toString(h1.getContador())+" Prioridad: "+Integer.toString(h1.getPriority()),20,140);
        
        g.drawString("Hilo 2: "+Integer.toString(h2.getContador())+" Prioridad: "+Integer.toString(h2.getPriority()),20,180);
        
        g.drawString("Hilo 3: "+Integer.toString(h3.getContador())+" Prioridad: "+Integer.toString(h3.getPriority()),20,220);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==finalizartodos){
            if(h1.isAlive() || h2.isAlive() || h3.isAlive()){
                h1.setParado(true);
                h2.setParado(true);
                h3.setParado(true);
            }
        }
        
        if(e.getSource()==b1mas){
            if(h1.getPriority()<10)
                h1.setPriority(10);
        }
        
        if(e.getSource()==b1menos){
            if(h1.getPriority()>1)
                h1.setPriority(1);
        }
        
        if(e.getSource()==b1parar){
            if(h1.isAlive())
                h1.setParado(true);
        }
        
        if(e.getSource()==b2mas){
            if(h2.getPriority()<10)
                h2.setPriority(10);
        }
        
        if(e.getSource()==b2menos){
            if(h2.getPriority()>1)
                h2.setPriority(1);
        }
        
        if(e.getSource()==b2parar){
            if(h2.isAlive())
                h2.setParado(true);
        }
        
        if(e.getSource()==b3mas){
            if(h3.getPriority()<10)
                h3.setPriority(10);
        }
        
        if(e.getSource()==b3menos){
            if(h3.getPriority()>1)
                h3.setPriority(1);
        }
        
        if(e.getSource()==b3parar){
            if(h3.isAlive())
                h3.setParado(true);
        }
    }
}
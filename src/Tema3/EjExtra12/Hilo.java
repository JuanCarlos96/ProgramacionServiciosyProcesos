package Tema3.EjExtra12;

import java.net.Socket;
import java.io.*;

public class Hilo extends Thread{
    private Socket c;
    private BufferedReader br;
    private PrintWriter pw;

    public Hilo(Socket c) {
        this.c = c;
        
        try {
            pw = new PrintWriter(c.getOutputStream(), true);
            br = new BufferedReader(new InputStreamReader(c.getInputStream()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
}
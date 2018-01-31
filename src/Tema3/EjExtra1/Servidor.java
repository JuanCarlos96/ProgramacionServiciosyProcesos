package Tema3.EjExtra1;

import java.io.*;
import java.net.*;

public class Servidor {
    public static void main(String[] args) {
        try {
            ServerSocket servidor = new ServerSocket(49500);
        } catch (Exception e) {
        }
    }
    
    private static int nFibonacci(int ntermino){
        int n=0, n1=1, n2=1;
        
        for(int i=2; i<ntermino; i++){
            n=n1+n2;
            n1=n2;
            n2=n;
        }
        
        return n;
    }
}
package Tema3.Ejemplo2;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class NewMain {
    public static void main(String[] args) {
        URL url=null;
        Scanner teclado = new Scanner(System.in);
        System.out.print("Introduzca dirección URL: ");
        String direccion = teclado.next();
        try {
            url = new URL(direccion);
        } catch (MalformedURLException e) { e.printStackTrace();}

        BufferedReader in;
        try {
            InputStream is = url.openStream();
            in = new BufferedReader(new InputStreamReader(is));
            String inputLine;
            while((inputLine = in.readLine()) != null){
                System.out.println(inputLine);
            }
            in.close();
        }catch(IOException e) {e.printStackTrace();}
    }
}
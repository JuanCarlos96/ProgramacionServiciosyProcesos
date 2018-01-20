package Tema2.EjExtra7;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NewMain {
    public static void main(String[] args) {
        PlantillaEmpresa plantilla = new PlantillaEmpresa();
        ActualizaLista actualizaLista = new ActualizaLista(plantilla);
        AnalizaSalarios analizaSalarios = new AnalizaSalarios(plantilla);
        Scanner teclado = new Scanner(System.in);
        
        while(true){
            System.out.println("\n\n------MENÚ------");
            System.out.println("1. Listar empleados");
            System.out.println("2. Agregar empleado");
            System.out.println("3. Eliminar empleado");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = teclado.nextInt();
            
            switch(opcion){
                case 1:
                    actualizaLista.setOpcion(opcion);
                    actualizaLista.start();
                    analizaSalarios.start();
                    try {
                        analizaSalarios.join();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(NewMain.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case 2:
                    actualizaLista.setOpcion(opcion);
                    actualizaLista.start();
                    analizaSalarios.start();
                    try {
                        analizaSalarios.join();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(NewMain.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case 3:
                    actualizaLista.setOpcion(opcion);
                    actualizaLista.start();
                    analizaSalarios.start();
                    try {
                        analizaSalarios.join();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(NewMain.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                default:
                    System.exit(0);
                    break;
            }
        }
    }
}
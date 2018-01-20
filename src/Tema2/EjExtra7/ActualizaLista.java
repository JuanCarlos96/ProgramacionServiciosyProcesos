package Tema2.EjExtra7;

import java.util.Scanner;

public class ActualizaLista extends Thread{
    private PlantillaEmpresa plantilla;
    private int opcion;
    private Scanner teclado = new Scanner(System.in);

    public ActualizaLista(PlantillaEmpresa plantilla) {
        this.plantilla = plantilla;
    }
    
    @Override
    public void run(){
        switch(this.opcion){
            case 1:
                this.plantilla.mostrarDatos();
                break;
            case 2:
                System.out.print("Introduce ID(número entero) del empleado: ");
                int id = teclado.nextInt();
                System.out.print("Introduce nombre del empleado: ");
                String nombre = teclado.next();
                System.out.print("Introduce salario(número real) del empleado: ");
                float salario = teclado.nextFloat();
                this.plantilla.agregarEmpleado(new Empleado(id,nombre,salario));
                break;
            default:
                System.out.print("Introduce el ID del empleado que quiere eliminar: ");
                int id2 = teclado.nextInt();
                this.plantilla.eliminarEmpleado(id2);
                break;
        }
    }

    public void setOpcion(int opcion) {
        this.opcion = opcion;
    }
}
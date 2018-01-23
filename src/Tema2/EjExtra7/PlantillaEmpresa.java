package Tema2.EjExtra7;

import java.util.ArrayList;

public class PlantillaEmpresa {
    private ArrayList<Empleado> empleados;
    private float media, min, max;
    private boolean operando = true;

    public PlantillaEmpresa() {
    }
    
    //--------------------------MÉTODOS DEL HILO ACTUALIZA LISTA------------------------------
    public synchronized void mostrarDatos(){
        if(!this.empleados.isEmpty()){
            for(Empleado e:this.empleados){
                System.out.println(e);
            }
        }else{
            System.out.println("No hay ningún empleado en la plantilla");
        }
        notifyAll();
    }
    
    public synchronized void agregarEmpleado(Empleado e){
        while(operando){
            try{
                wait();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        this.empleados.add(e);
        System.out.println("Nuevo empleado añadido");
        operando = true;
        notifyAll();
    }
    
    public synchronized void eliminarEmpleado(int id){
        boolean encontrado = false;
        while(operando){
            try{
                wait();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        for(Empleado e:this.empleados){
            if(e.getId()==id){
                encontrado = true;
                this.empleados.remove(e);
                System.out.println("El empleado con ID: "+id+" ha sido eliminado");
            }
        }
        if(!encontrado){
            System.out.println("No existe un empleado con ID: "+id);
        }
        operando = true;
        notifyAll();
    }
    //----------------------------------------------------------------------------------------
    
    //--------------------------MÉTODOS DEL HILO ANALIZA SALARIOS-----------------------------
    public synchronized void calcularMedia(){
        while(!operando){
            try{
                wait();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        float total = 0;
        for(Empleado e:this.empleados){
            total+=e.getSalario();
        }
        this.media = total/this.empleados.size();
        operando=false;
    }
    
    public synchronized void calcularMinimo(){
        while(!operando){
            try{
                wait();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        float min = Float.MAX_VALUE;
        for(Empleado e:this.empleados){
            if(e.getSalario()<min){
                min = e.getSalario();
            }
        }
        operando=false;
    }
    
    public synchronized void calcularMaximo(){
        while(!operando){
            try{
                wait();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        float max = Float.MIN_VALUE;
        for(Empleado e:this.empleados){
            if(e.getSalario()>max){
                max = e.getSalario();
            }
        }
        operando=false;
    }

    public synchronized float getMedia() {
        while(operando){
            try{
                wait();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        return media;
    }

    public synchronized float getMin() {
        while(operando){
            try{
                wait();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        return min;
    }

    public synchronized float getMax() {
        while(operando){
            try{
                wait();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        return max;
    }
    //----------------------------------------------------------------------------------------
}
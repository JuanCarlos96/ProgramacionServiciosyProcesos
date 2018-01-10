package Tema2.EjExtra7;

import java.util.ArrayList;

public class PlantillaEmpresa {
    private ArrayList<Empleado> empleados;
    private float media, min, max;

    public PlantillaEmpresa() {
    }
    
    public synchronized void mostrarDatos(){
        for(Empleado e:this.empleados){
            System.out.println(e);
        }
    }
    
    public synchronized void agregarEmpleado(Empleado e){
        this.empleados.add(e);
    }
    
    public synchronized void eliminarEmpleado(int id){
        for(Empleado e:this.empleados){
            if(e.getId()==id){
                this.empleados.remove(e);
            }
        }
    }
    
    public synchronized void calcularMedia(){
        float total = 0;
        for(Empleado e:this.empleados){
            total+=e.getSalario();
        }
        this.media = total/this.empleados.size();
    }
    
    public synchronized void calcularMinimo(){
        float min = Float.MAX_VALUE;
        for(Empleado e:this.empleados){
            if(e.getSalario()<min){
                min = e.getSalario();
            }
        }
    }
    
    public synchronized void calcularMaximo(){
        float max = Float.MIN_VALUE;
        for(Empleado e:this.empleados){
            if(e.getSalario()>max){
                max = e.getSalario();
            }
        }
    }

    public float getMedia() {
        return media;
    }

    public float getMin() {
        return min;
    }

    public float getMax() {
        return max;
    }
}
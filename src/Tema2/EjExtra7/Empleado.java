package Tema2.EjExtra7;

public class Empleado {
    private int id;
    private String nombre;
    private float salario;

    public Empleado(int id, String nombre, float salario) {
        this.id = id;
        this.nombre = nombre;
        this.salario = salario;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public float getSalario() {
        return salario;
    }
    
    @Override
    public String toString(){
        return Integer.toString(getId())+" "+getNombre()+" "+Float.toString(getSalario());
    }
}
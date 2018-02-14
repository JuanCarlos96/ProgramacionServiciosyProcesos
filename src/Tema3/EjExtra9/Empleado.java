package Tema3.EjExtra9;

import java.io.Serializable;

public class Empleado implements Serializable{
    private String nombre, apellidos, iddep;
    private float salario;
    private int antiguedad;

    public Empleado(String nombre, String apellidos, String iddep, float salario, int antiguedad) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.iddep = iddep;
        this.salario = salario;
        this.antiguedad = antiguedad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getIddep() {
        return iddep;
    }

    public float getSalario() {
        return salario;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }
}
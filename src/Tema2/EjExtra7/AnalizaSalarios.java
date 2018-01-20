package Tema2.EjExtra7;

public class AnalizaSalarios extends Thread{
    private PlantillaEmpresa plantilla;

    public AnalizaSalarios(PlantillaEmpresa plantilla) {
        this.plantilla = plantilla;
    }

    @Override
    public void run() {
        this.plantilla.calcularMedia();
        this.plantilla.calcularMaximo();
        this.plantilla.calcularMinimo();
        System.out.println("Media: "+this.plantilla.getMedia());
        System.out.println("Máximo: "+this.plantilla.getMax());
        System.out.println("Mínimo: "+this.plantilla.getMin());
    }
}
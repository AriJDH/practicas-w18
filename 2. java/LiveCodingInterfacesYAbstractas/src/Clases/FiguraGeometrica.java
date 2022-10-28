package Clases;
import Interfaces.Coloreable;

public abstract class FiguraGeometrica implements Coloreable {
    private int posX;
    private int posY;

    public FiguraGeometrica(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public abstract double calcularArea();

    @Override
    public void pintarRojo() {
        System.out.println("La figura geometrica ahora es roja.");
    }

    @Override
    public void pintarVerde() {
        System.out.println("La figura geometrica ahora es verde.");
    }

    @Override
    public void pintarAzul() {
        System.out.println("La figura geometrica ahora es azul.");
    }
}

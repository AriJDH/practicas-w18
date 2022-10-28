package Clases;

public class Circulo extends FiguraGeometrica{
    private float radio;

    public Circulo(int posX, int posY, float radio) {
        super(posX, posY);
        this.radio = radio;
    }


    @Override
    public double calcularArea() {
        return Math.PI * radio * radio;
    }
}

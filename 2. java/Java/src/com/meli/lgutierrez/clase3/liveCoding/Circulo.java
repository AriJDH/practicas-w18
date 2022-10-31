package com.meli.lgutierrez.clase3.liveCoding;

public class Circulo extends FiguraGeometrica{

    private float radio;

    public Circulo(int posX, int posY) {
        super(posX, posY);
    }

    public Circulo(int posX, int posY, float radio) {
        super(posX, posY);
        this.radio = radio;
    }

    @Override
    public double calcularArea() {
        return Math.PI * (radio * radio);
    }
}

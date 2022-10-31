package com.meli.lgutierrez.clase3.liveCoding;

public class Triangulo extends FiguraGeometrica{

    private double base;
    private double altura;

    public Triangulo(int posX, int posY) {
        super(posX, posY);
    }

    public Triangulo(int posX, int posY, double base, double altura) {
        super(posX, posY);
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double calcularArea() {
        return (base * altura)/2;
    }
}

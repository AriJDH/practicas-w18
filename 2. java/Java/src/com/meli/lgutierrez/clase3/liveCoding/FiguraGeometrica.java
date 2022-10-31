package com.meli.lgutierrez.clase3.liveCoding;

public abstract class FiguraGeometrica {

    private int posX;
    private int posY;

    public FiguraGeometrica(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public abstract double calcularArea();
}

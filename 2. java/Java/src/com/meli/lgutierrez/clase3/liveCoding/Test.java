package com.meli.lgutierrez.clase3.liveCoding;

public class Test {
    public static void main(String[] args) {
        FiguraGeometrica triangulo = new Triangulo(1, 2, 2, 10);
        System.out.println("El área del triangulo es: " + triangulo.calcularArea());

        Circulo circulo = new Circulo(1, 2, 5);
        System.out.println("El área del circulo es: " + circulo.calcularArea());

        triangulo = new Circulo(1, 2, 5);
        System.out.println("El área del circulo es: " + triangulo.calcularArea());
    }
}

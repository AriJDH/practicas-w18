package com.meli.domain;

public class PracticaExcepciones {
    private int a = 0;
    private int b = 300;

    public double calcularCociente() throws IllegalArgumentException {
        try {
            return this.b/this.a;
        }catch(Exception e){
            throw new IllegalArgumentException("No se puede dividir por cero");
        }finally {
            System.out.println("Programa finalizado");
        }
    }
}

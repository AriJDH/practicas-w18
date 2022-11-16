package com.meli.lgutierrez.clase5.ejercicioPractico2;

public class Auto extends Vehiculo{

    public static final Double PESO = 1000D;

    public Auto(Double velocidad, Double aceleracion, Double anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente, PESO, 4);
    }
}

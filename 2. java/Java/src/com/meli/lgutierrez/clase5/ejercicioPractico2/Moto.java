package com.meli.lgutierrez.clase5.ejercicioPractico2;

public class Moto extends Vehiculo{

    public static final Double PESO = 300D;

    public Moto(Double velocidad, Double aceleracion, Double anguloDeGiro, String patente, Double peso) {
        super(velocidad, aceleracion, anguloDeGiro, patente, PESO, 2);
    }

}

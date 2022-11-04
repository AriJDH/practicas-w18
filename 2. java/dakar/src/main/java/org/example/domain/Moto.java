package org.example.domain;


public class Moto extends Vehiculo{
    private static double PESO_MOTO = 300;
    private static int RUEDAS_MOTO = 2;

    public Moto(double velocidad, double aceleracion, double anguloGiro, String patente) {
        super(velocidad, aceleracion, anguloGiro, patente, PESO_MOTO, RUEDAS_MOTO);
    }
}

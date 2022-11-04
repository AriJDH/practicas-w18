package org.example.domain;

public class Auto extends Vehiculo{
    private static double PESO_AUTO = 1000;
    private static int RUEDAS_AUTO = 4;

    public Auto(double velocidad, double aceleracion, double anguloGiro, String patente) {
        super(velocidad, aceleracion, anguloGiro, patente, PESO_AUTO, RUEDAS_AUTO);
    }
}

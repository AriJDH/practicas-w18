package org.example.domain;

public class SocorristaAuto extends Vehiculo{
    public SocorristaAuto(double velocidad, double aceleracion, double anguloGiro, String patente, double peso, int ruedas) {
        super(velocidad, aceleracion, anguloGiro, patente, peso, ruedas);
    }

    public void socorrerAuto(Auto auto){
        System.out.println("Socorriendo auto " + auto.getPatente());
    }
}

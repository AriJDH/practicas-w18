package org.example.domain;

public class SocorristaMoto extends Vehiculo{
    public SocorristaMoto(double velocidad, double aceleracion, double anguloGiro, String patente, double peso, int ruedas) {
        super(velocidad, aceleracion, anguloGiro, patente, peso, ruedas);
    }

    public void socorrerMoto(Moto moto){
        System.out.println("Socorriendo moto " + moto.getPatente());
    }
}

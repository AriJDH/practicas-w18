package org.example.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public @Data abstract class Vehiculo {
    @EqualsAndHashCode.Include
    private double velocidad;
    @EqualsAndHashCode.Include
    private double aceleracion;
    @EqualsAndHashCode.Include
    private double anguloGiro;
    @EqualsAndHashCode.Include
    private String patente;
    @EqualsAndHashCode.Include
    private double peso;
    @EqualsAndHashCode.Include
    private int ruedas;

    public Vehiculo(double velocidad, double aceleracion, double anguloGiro, String patente, double peso, int ruedas) {
        this.velocidad = velocidad;
        this.aceleracion = aceleracion;
        this.anguloGiro = anguloGiro;
        this.patente = patente;
        this.peso = peso;
        this.ruedas = ruedas;
    }

    public double getPuntaje(){
        return this.velocidad * 0.5* this.aceleracion * (this.anguloGiro*(this.peso-this.ruedas*100));
    }
}

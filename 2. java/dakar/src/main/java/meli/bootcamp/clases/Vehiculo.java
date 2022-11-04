package meli.bootcamp.clases;

public class Vehiculo {
    private double velocidad;
    private double aceleracion;
    private double anguloGiro;
    private String patente;
    private double peso;
    private int ruedas;

    public Vehiculo(double velocidad, double aceleracion, double anguloGiro, String patente, double peso, int ruedas) {
        this.velocidad = velocidad;
        this.aceleracion = aceleracion;
        this.anguloGiro = anguloGiro;
        this.patente = patente;
        this.peso = peso;
        this.ruedas = ruedas;
    }

    public String getPatente() {
        return patente;
    }

    public double getVelocidad() {
        return velocidad;
    }

    public double getAceleracion() {
        return aceleracion;
    }

    public double getAnguloGiro() {
        return anguloGiro;
    }

    public double getPeso() {
        return peso;
    }

    public int getRuedas() {
        return ruedas;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("vehiculo{");
        sb.append("velocidad=").append(velocidad);
        sb.append(", aceleracion=").append(aceleracion);
        sb.append(", anguloGiro=").append(anguloGiro);
        sb.append(", patente='").append(patente).append('\'');
        sb.append(", peso=").append(peso);
        sb.append(", ruedas=").append(ruedas);
        sb.append('}');
        return sb.toString();
    }
}

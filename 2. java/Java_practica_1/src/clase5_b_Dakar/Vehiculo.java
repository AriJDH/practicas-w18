package clase5_b_Dakar;

import java.util.Objects;

public abstract class Vehiculo {
    protected Double velocidad;
    protected Double aceleracion;
    protected Double anguloDeGiro;
    protected String patente;
    protected Double peso;
    protected Integer ruedas;

    public Vehiculo() {
    }

    public Vehiculo(Double velocidad, Double aceleracion, Double anguloDeGiro, String patente, Double peso, Integer ruedas) {
        this.velocidad = velocidad;
        this.aceleracion = aceleracion;
        this.anguloDeGiro = anguloDeGiro;
        this.patente = patente;
        this.peso = peso;
        this.ruedas = ruedas;
    }
    @Override
    public boolean equals(Object o) {
        if (o instanceof Vehiculo) {
            Vehiculo veh = (Vehiculo)o;
            return this.patente.equals(veh.patente);
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "velocidad=" + velocidad +
                ", aceleracion=" + aceleracion +
                ", anguloDeGiro=" + anguloDeGiro +
                ", patente='" + patente + '\'' +
                ", peso=" + peso +
                ", ruedas=" + ruedas +
                '}';
    }

    public boolean equals(String patente) {
        return this.patente.equals(patente);
    }

    public double getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(double velocidad) {
        this.velocidad = velocidad;
    }

    public double getAceleracion() {
        return aceleracion;
    }

    public void setAceleracion(double aceleracion) {
        this.aceleracion = aceleracion;
    }

    public double getAnguloDeGiro() {
        return anguloDeGiro;
    }

    public void setAnguloDeGiro(double anguloDeGiro) {
        this.anguloDeGiro = anguloDeGiro;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getRuedas() {
        return ruedas;
    }

    public void setRuedas(int ruedas) {
        this.ruedas = ruedas;
    }

}

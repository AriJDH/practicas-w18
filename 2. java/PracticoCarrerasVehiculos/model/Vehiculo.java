package ejercicio2.model;

public abstract class Vehiculo {

    private int velocidad;
    private int aceleracion;
    private int anguloDeGiro;
    private int peso;
    private int ruedas;
    private String patente;


    public Vehiculo() {
    }

    public Vehiculo(int velocidad, int aceleracion, int anguloDeGiro, int peso, int ruedas, String patente) {
        this.velocidad = velocidad;
        this.aceleracion = aceleracion;
        this.anguloDeGiro = anguloDeGiro;
        this.peso = peso;
        this.ruedas = ruedas;
        this.patente = patente;
    }


    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public int getAceleracion() {
        return aceleracion;
    }

    public void setAceleracion(int aceleracion) {
        this.aceleracion = aceleracion;
    }

    public int getAnguloDeGiro() {
        return anguloDeGiro;
    }

    public void setAnguloDeGiro(int anguloDeGiro) {
        this.anguloDeGiro = anguloDeGiro;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getRuedas() {
        return ruedas;
    }

    public void setRuedas(int ruedas) {
        this.ruedas = ruedas;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

}

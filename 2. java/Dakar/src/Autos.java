public class Autos extends Vehiculo {
    private double velocidad;
    private double aceleracion;
    private double anguloDeGiro;
    private String patente;
    private int peso = 1000;
    private int ruedas = 4;

    public Autos(double velocidad, double aceleracion, double anguloDegiro, String patente) {
    }

    @Override
    public double getVelocidad() {
        return velocidad;
    }

    @Override
    public void setVelocidad(double velocidad) {
        this.velocidad = velocidad;
    }

    @Override
    public double getAceleracion() {
        return aceleracion;
    }

    @Override
    public void setAceleracion(double aceleracion) {
        this.aceleracion = aceleracion;
    }

    @Override
    public double getAnguloDeGiro() {
        return anguloDeGiro;
    }

    @Override
    public void setAnguloDeGiro(double anguloDeGiro) {
        this.anguloDeGiro = anguloDeGiro;
    }

    @Override
    public String getPatente() {
        return patente;
    }

    @Override
    public void setPatente(String patente) {
        this.patente = patente;
    }

    @Override
    public int getPeso() {
        return peso;
    }

    @Override
    public void setPeso(int peso) {
        this.peso = peso;
    }

    @Override
    public int getRuedas() {
        return ruedas;
    }

    @Override
    public void setRuedas(int ruedas) {
        this.ruedas = ruedas;
    }
}

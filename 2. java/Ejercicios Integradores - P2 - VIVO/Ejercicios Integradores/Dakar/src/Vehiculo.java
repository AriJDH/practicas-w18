public class Vehiculo {

    private double velocidad;
    private double aceleracion;
    private double anguloDeGiro;
    private String patente;

    public Vehiculo() {

    }

    public Vehiculo(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        this.velocidad = velocidad;
        this.aceleracion = aceleracion;
        this.anguloDeGiro = anguloDeGiro;
        this.patente = patente;
    }

    public double getVelocidad() {
        return this.velocidad;
    }

    public void setVelocidad(double velocidad) {
        this.velocidad = velocidad;
    }

    public double getAceleracion() {
        return this.aceleracion;
    }

    public void setAceleracion(double aceleracion) {
        this.aceleracion = aceleracion;
    }

    public double getAnguloDeGiro() {
        return this.anguloDeGiro;
    }

    public void setAnguloDeGiro(double anguloDeGiro) {
        this.anguloDeGiro = anguloDeGiro;
    }

    public String getPatente() {
        return this.patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }






    @Override
    public String toString() {
        return "Datos del vehiculo:" + "\n" +
                "Velocidad: " + this.velocidad + "\n" +
                "Aceleración: " + this.aceleracion + "\n" +
                "Angulo de giro: " + this.anguloDeGiro + "\n" +
                "Patente: " + this.patente;
    }


}

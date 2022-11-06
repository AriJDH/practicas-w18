public class Vehiculo {
    private Double velocidad;
    private Double aceleracion;
    private Double anguloGiro;
    private String patente;
    private Double peso;
    private Integer ruedas;
    private Double maxTot;

    public Vehiculo(Double velocidad, Double aceleracion, Double anguloGiro, String patente, Double peso, Integer ruedas) {
        this.velocidad = velocidad;
        this.aceleracion = aceleracion;
        this.anguloGiro = anguloGiro;
        this.patente = patente;
        this.peso = peso;
        this.ruedas = ruedas;
    }

    public Double getVelocidad() {
        return velocidad;
    }

    public Double getMaxTot() {
        return velocidad*(aceleracion/2)/(anguloGiro*(peso-ruedas*100));
    }

    public void setVelocidad(Double velocidad) {
        this.velocidad = velocidad;
    }

    public Double getAceleracion() {
        return aceleracion;
    }

    public void setAceleracion(Double aceleracion) {
        this.aceleracion = aceleracion;
    }

    public Double getAnguloGiro() {
        return anguloGiro;
    }

    public void setAnguloGiro(Double anguloGiro) {
        this.anguloGiro = anguloGiro;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public Double getPeso() {
        return peso;
    }


    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Integer getRuedas() {
        return ruedas;
    }

    public void setRuedas(Integer ruedas) {
        this.ruedas = ruedas;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "velocidad=" + velocidad +
                ", aceleracion=" + aceleracion +
                ", anguloGiro=" + anguloGiro +
                ", patente='" + patente + '\'' +
                ", peso=" + peso +
                ", ruedas=" + ruedas +
                '}';
    }
}

public class Vehiculo {

    private Integer velocidad;
    private Integer aceleración;
    private Integer anguloDeGiro;
    private String patente;
    private Double peso;
    private Integer ruedas;

    public Vehiculo() {
    }

    public Vehiculo(Integer velocidad, Integer aceleración, Integer anguloDeGiro, String patente) {
        this.velocidad = velocidad;
        this.aceleración = aceleración;
        this.anguloDeGiro = anguloDeGiro;
        this.patente = patente;
    }

    public Integer getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(Integer velocidad) {
        this.velocidad = velocidad;
    }

    public Integer getAceleración() {
        return aceleración;
    }

    public void setAceleración(Integer aceleración) {
        this.aceleración = aceleración;
    }

    public Integer getAnguloDeGiro() {
        return anguloDeGiro;
    }

    public void setAnguloDeGiro(Integer anguloDeGiro) {
        this.anguloDeGiro = anguloDeGiro;
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
                ", aceleración=" + aceleración +
                ", anguloDeGiro=" + anguloDeGiro +
                ", patente='" + patente + '\'' +
                ", peso=" + peso +
                ", ruedas=" + ruedas +
                '}';
    }
}

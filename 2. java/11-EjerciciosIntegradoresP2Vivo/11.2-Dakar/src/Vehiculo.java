public abstract class Vehiculo {

    // Atributo
    protected Double velocidad;
    protected Double aceleracion;
    protected Double anguloDeGiro;
    protected String patente;
    protected Double peso;
    protected Integer ruedas;

    // Constructores
    public Vehiculo() {
    }

    public Vehiculo(Double velocidad,
                    Double aceleracion,
                    Double anguloDeGiro,
                    String patente,
                    Double peso,
                    Integer ruedas) {
        this.velocidad = velocidad;
        this.aceleracion = aceleracion;
        this.anguloDeGiro = anguloDeGiro;
        this.patente = patente;
        this.peso = peso;
        this.ruedas = ruedas;
    }

    public Vehiculo(Double velocidad,
                    Double aceleracion,
                    Double anguloDeGiro,
                    String patente) {
        this.velocidad = velocidad;
        this.aceleracion = aceleracion;
        this.anguloDeGiro = anguloDeGiro;
        this.patente = patente;
    }

    // Getters y setters
    public String getPatente() {
        return patente;
    }

    public Double getVelocidad() {
        return velocidad;
    }

    public Double getAceleracion() {
        return aceleracion;
    }

    public Double getAnguloDeGiro() {
        return anguloDeGiro;
    }

    public Double getPeso() {
        return peso;
    }

    public Integer getRuedas() {
        return ruedas;
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
}

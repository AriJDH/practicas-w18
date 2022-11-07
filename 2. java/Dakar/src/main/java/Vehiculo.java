public abstract class Vehiculo {
    private double velocidad;
    private double aceleracion;
    private int anguloDeGiro;
    private String patente;
    private int peso;
    private int ruedas;
    private double puntaje;

    public Vehiculo(double velocidad, double aceleracion, int anguloDeGiro, String patente, int peso, int ruedas) {
        this.velocidad = velocidad;
        this.aceleracion = aceleracion;
        this.anguloDeGiro = anguloDeGiro;
        this.patente = patente;
        this.peso = peso;
        this.ruedas = ruedas;
    }

    public double puntaje() {
        return velocidad * (aceleracion/2) / (anguloDeGiro * (peso - ruedas*100) );
    }

    public void imprimir(){
        System.out.println(toString());
    }


    public void setPuntaje(){
        this.puntaje = puntaje();
    }

    public double getPuntaje() {
        return puntaje;
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

    public int getAnguloDeGiro() {
        return anguloDeGiro;
    }

    public void setAnguloDeGiro(int anguloDeGiro) {
        this.anguloDeGiro = anguloDeGiro;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
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

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " {" +
                "velocidad = " + velocidad +
                ", aceleracion = " + aceleracion +
                ", anguloDeGiro = " + anguloDeGiro +
                ", patente = '" + patente + '\'' +
                ", peso = " + peso +
                ", ruedas = " + ruedas +
                ", puntaje = " + puntaje +
                '}';
    }
}

public class Moto extends Vehiculo{

    private double peso;
    private int ruedas;


    public Moto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente);
        this.peso = 300;
        this.ruedas = 2;
    }


}

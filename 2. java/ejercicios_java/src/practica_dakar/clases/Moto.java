package practica_dakar.clases;

public class Moto extends Vehiculo {

    private static final Double PESO = 300.0;

    private static final Integer CANTIDAD_RUEDAS = 2;

    public Moto(Double velocidad, Double aceleracion, Double anguloGiro, String patente) {
        super(velocidad, aceleracion, anguloGiro, patente, PESO, CANTIDAD_RUEDAS);
    }
}

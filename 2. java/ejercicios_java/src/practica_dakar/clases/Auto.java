package practica_dakar.clases;

public class Auto extends Vehiculo {

    private static final Double PESO = 1000.0;

    private static final Integer CANTIDAD_RUEDAS = 4;

    public Auto(Double velocidad, Double aceleracion, Double anguloGiro, String patente) {
        super(velocidad, aceleracion, anguloGiro, patente, PESO, CANTIDAD_RUEDAS);
    }

}

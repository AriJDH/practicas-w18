package clases;

public class Auto extends Vehiculo{
    private static final Double PESO_AUTO = 1000.0;
    private static final Integer CANTIDAD_RUEDAS_AUTO = 4;

    public Auto(Double velocidad, Double aceleracion, Double anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente,PESO_AUTO,CANTIDAD_RUEDAS_AUTO);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}


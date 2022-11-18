package clases;

public class Moto extends Vehiculo{
    private static final Double PESO_MOTO = 300.0;
    private static final Integer CANTIDAD_RUEDAS_MOTOS = 2;

    public Moto(Double velocidad, Double aceleracion, Double anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente,PESO_MOTO,CANTIDAD_RUEDAS_MOTOS);
    }

    @Override
    public String toString() {
        return super.toString();
    }

}

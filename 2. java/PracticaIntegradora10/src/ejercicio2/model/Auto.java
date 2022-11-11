package ejercicio2.model;

public class Auto extends Vehiculo {

    public static final int PESO_DEFAULT = 1000;
    public static final int CANT_RUEDAS = 4;

    public Auto(int velocidad, int aceleracion, int anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, PESO_DEFAULT, CANT_RUEDAS, patente);
    }


}

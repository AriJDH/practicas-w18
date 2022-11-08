package ejercicio2.model;

public class Moto extends Vehiculo {

    public static final int PESO_DEFAULT = 300;
    public static final int CANT_RUEDAS = 2;

    public Moto(int velocidad, int aceleracion, int anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, PESO_DEFAULT, CANT_RUEDAS, patente);
    }


}

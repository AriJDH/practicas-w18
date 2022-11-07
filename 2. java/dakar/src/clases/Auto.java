package clases;

public class Auto extends Vehiculo{
    static final double pesoDefinido = 1000.0;
    static final int ruedasDefinidas = 4;

    public Auto(){}
    public Auto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente, pesoDefinido, ruedasDefinidas);
    }
}

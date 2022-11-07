package clases;

public class Moto extends Vehiculo{
    static final double pesoDefinido = 300;
    static final int ruedasDefinidas = 2;

    public Moto(){}
    public Moto(double velocidad, double aceleracion, double anguloDeGiro, String patente){
        super(velocidad,aceleracion, anguloDeGiro, patente, pesoDefinido, ruedasDefinidas );
    }
}

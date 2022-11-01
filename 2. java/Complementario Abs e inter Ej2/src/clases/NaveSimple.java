package clases;

public class NaveSimple extends Nave {

    public NaveSimple(String nombre) {
        super(nombre);
    }

    private double calcularDistancia(double x, double y){
        double cuenta = Math.pow(getEjeX() - x, 2) + Math.pow(getEjeY() - y, 2);
        double distancia = Math.sqrt(cuenta);

        return distancia;
    }

    @Override
    public double mover(double x, double y) {
        return calcularDistancia(x, y);
    }
}

package clases;

public class NaveSimple extends Nave {
    public NaveSimple() {
    }
    public NaveSimple(String nombre){
        super(nombre);
    }
    private double calcularDistancia(double x, double y){
        double cuenta = Math.pow(getEjeX() - x, 2) + Math.pow(getEjeY() - y, 2);
        double distancia = Math.sqrt(cuenta);
        return distancia;
    }
    @Override
    public void sumarPunto() {
        super.sumarPunto();
    }

    @Override
    public double getEjeX() {
        return super.getEjeX();
    }

    @Override
    public double getEjeY() {
        return super.getEjeY();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public int getPuntos() {
        return super.getPuntos();
    }
}

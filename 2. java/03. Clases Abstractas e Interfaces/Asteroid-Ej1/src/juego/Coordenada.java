package juego;

public class Coordenada {
    private double x;
    private double y;

    public Coordenada(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double calcularDistanciaA(Coordenada coordenada){
        double diferenciaEnX= this.x - coordenada.x;
        double diferenciaEnY= this.y - coordenada.y;
        return Math.hypot(diferenciaEnX,diferenciaEnY);
    }

    @Override
    public String toString() {
        return "(x=" + x + "; y=" + y +')';
    }

}

package practica_complementario_clase_abstracta.ejercicio2;

public class NaveSimple implements INave {

    private String nombre;

    private int x;

    private int y;

    public NaveSimple(String nombre, int x, int y) {
        this.nombre = nombre;
        this.x = x;
        this.y = y;
    }

    private int puntuacion = 0;

    @Override
    public double acumularPuntos(int x, int y) {

        double distancia = Math.sqrt(Math.pow((this.x - x), 2) + Math.pow((this.y - y), 2));

        return distancia;
    }

    @Override
    public int getPuntuacion() {
        return puntuacion;
    }
}

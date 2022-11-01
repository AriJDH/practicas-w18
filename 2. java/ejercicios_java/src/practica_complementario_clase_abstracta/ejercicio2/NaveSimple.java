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

    public NaveSimple() {
    }

    @Override
    public double calcularDistancia(int x, int y) {

        //Obtener distancia entre los dos puntos
        return Math.sqrt(Math.pow((this.x - x), 2) + Math.pow((this.y - y), 2));
    }

    @Override
    public int getPuntuacion() {
        return puntuacion;
    }

    @Override
    public String toString() {
        return "NaveSimple{" +
                "nombre='" + nombre + '\'' +
                ", x=" + x +
                ", y=" + y +
                ", puntuacion=" + puntuacion +
                '}';
    }
}

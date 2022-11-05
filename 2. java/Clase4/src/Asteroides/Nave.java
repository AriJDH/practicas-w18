package Asteroides;

public class Nave implements Component{
    private String nombre;
    private int ejeX;
    private int ejeY;
    private int puntuacion;

    public Nave(String nombre, int ejeX, int ejeY) {
        this.nombre = nombre;
        this.ejeX = ejeX;
        this.ejeY = ejeY;
        this.puntuacion = 0;
    }

    @Override
    public double calcularPuntos(int x, int y) {
        double distancia;
        distancia = Math.sqrt(Math.pow((this.ejeX - x), 2) + Math.pow((this.ejeY - y), 2));
        return distancia;
    }

    @Override
    public void addNave(Component nave) {
        System.out.println("No se puede anadir una nave, no es una flota");
    }
}

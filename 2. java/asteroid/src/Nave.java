public class Nave implements Componente{
    /** Esta es la clase leaf **/

    private String nombre;
    private double x;
    private double y;
    private int puntuacion;

    public Nave(String nombre, double x, double y) {
        this.nombre = nombre;
        this.x = x;
        this.y = y;
        this.puntuacion = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    @Override
    public double getDistancia() {
        return Math.sqrt(Math.pow(this.x- 2*(this.x), 2) + Math.pow(this.y- 2*(this.y), 2));
    }

    @Override
    public void add(Componente e) {

    }

    @Override
    public void delete(Componente e) {

    }
}

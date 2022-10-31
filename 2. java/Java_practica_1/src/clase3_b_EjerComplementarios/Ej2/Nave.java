package clase3_b_EjerComplementarios.Ej2;

public class Nave implements Navegable {
    private int x;
    private int y;
    private String nombre;
    private Double puntuacion;

    public Nave(String nombre, int x, int y) {
        this.x = x;
        this.y = y;
        this.nombre = nombre;
        this.puntuacion = Double.valueOf(0);
    }

    @Override
    public String toString() {
        return "Nave{" +
                "x=" + x +
                ", y=" + y +
                ", nombre='" + nombre + '\'' +
                ", puntuacion=" + puntuacion +
                '}';
    }

    @Override
    public double getDistancia(int x, int y) {
        return Math.sqrt(Math.pow((this.x - x),2) + Math.pow((this.y - y),2));
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(Double puntuacion) {
        this.puntuacion = puntuacion;
    }
}

package clase3_b_EjerComplementarios.Ej2;

public class Nave implements INave {
    private int x;
    private int y;
    private String nombre;
    private Integer puntuacion;

    public Nave(String nombre, int x, int y) {
        this.x = x;
        this.y = y;
        this.nombre = nombre;
        this.puntuacion = 0;
    }

    @Override
    public String toString() {
        return "Nave{" +
                "coordenada= x: " + x + "| y: " + y +
                ", nombre='" + nombre + '\'' +
                ", puntuacion=" + puntuacion +
                '}';
    }

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public void add(INave nave) {
        // Sin implementación en clase hoja
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public void setPuntuacion() {
        this.puntuacion ++;
    }

    @Override
    public Integer getPuntaje() {
        return this.puntuacion;
    }

    @Override
    public double calcularDistancia(int x, int y) {
        return Math.sqrt(Math.pow((this.x - x),2) + Math.pow((this.y - y),2));
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(Integer puntuacion) {
        this.puntuacion = puntuacion;
    }
}

package clase3_b_EjerComplementarios.Ej2;

public class Nave implements Navegable {
   private Coordenada coordenada;
    private String nombre;
    private Double puntuacion;

    public Nave(String nombre, int x, int y) {
        this.coordenada = new Coordenada(x,y);
        this.nombre = nombre;
        this.puntuacion = Double.valueOf(0);
    }

    @Override
    public String toString() {
        return "Nave{" +
                "coordenada=" + coordenada +
                ", nombre='" + nombre + '\'' +
                ", puntuacion=" + puntuacion +
                '}';
    }

    @Override
    public double getDistancia(int x, int y) {
        return Math.sqrt(Math.pow((this.coordenada.x - x),2) + Math.pow((this.coordenada.y - y),2));
    }

    public int getX() {
        return this.coordenada.x;
    }

    public void setX(int x) {
        this.coordenada.x = x;
    }

    public int getY() {
        return this.coordenada.y;
    }

    public void setY(int y) {
        this.coordenada.y = y;
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

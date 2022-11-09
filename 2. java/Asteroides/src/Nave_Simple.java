public class Nave_Simple implements Nave{

    private int coordX;
    private int coordY;
    private String nombre;
    private int puntuacion;


    public Nave_Simple(int coordX, int coordY, String nombre) {
        this.coordX = coordX;
        this.coordY = coordY;
        this.nombre = nombre;
        this.puntuacion = 0;

    }

    @Override
    public double distancia(int x,int y) {
        return Math.sqrt(Math.pow((x-this.coordX),2)+Math.pow((y-this.coordY),2));
    }

    public int getPuntuacion() {
        return this.puntuacion;
    }

    public void setPuntuacion() {
        this.puntuacion += 1;
    }

    @Override
    public String toString() {
        return "Nave_Simple{" +
                "coordX=" + coordX +
                ", coordY=" + coordY +
                ", nombre='" + nombre + '\'' +
                ", puntuacion=" + puntuacion +
                '}';
    }
}

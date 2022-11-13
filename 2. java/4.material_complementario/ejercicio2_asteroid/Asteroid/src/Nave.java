public class Nave {
    String nombre;
    Double posX, posY;
    int puntuacion = 0;

    public Nave(String nombre, Double posX, Double posY, int puntuacion) {
        this.nombre = nombre;
        this.posX = posX;
        this.posY = posY;
        this.puntuacion = puntuacion;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPosX() {
        return posX;
    }

    public void setPosX(Double posX) {
        this.posX = posX;
    }

    public Double getPosY() {
        return posY;
    }

    public void setPosY(Double posY) {
        this.posY = posY;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }



}

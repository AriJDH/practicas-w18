package Ejercicio2;

public abstract class Nave {
    protected String nombre;
    protected String ubicacion;
    protected Integer puntuacion;

    public Nave(String nombre, String ubicacion, Integer puntuacion) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.puntuacion = puntuacion;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Integer getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(Integer puntuacion) {
        this.puntuacion = puntuacion;
    }

    @Override
    public String toString() {
        return "Nave{" +
                "nombre='" + nombre + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                ", puntuacion=" + puntuacion +
                '}';
    }
}

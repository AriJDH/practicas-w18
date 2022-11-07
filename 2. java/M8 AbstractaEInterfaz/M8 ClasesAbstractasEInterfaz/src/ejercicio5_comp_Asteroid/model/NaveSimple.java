package ejercicio5_comp_Asteroid.model;

import java.util.List;

public class NaveSimple implements INave{

    private String nombre;
    private List<Integer> ubicacion;// (x,y)
    int puntuacion;

    public NaveSimple() {
    }

    public NaveSimple(String nombre, List<Integer> ubicacion) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.puntuacion = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Integer> getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(List<Integer> ubicacion) {
        this.ubicacion = ubicacion;
    }

    protected int getPuntuacion() {
        return puntuacion;
    }

    protected void setPuntuacion(int puntuacion) {
        this.puntuacion += 1;
    }

    @Override
    public String toString() {
        return "NaveSimple{" +
                "nombre='" + nombre + '\'' +
                ", ubicacion=" + ubicacion +
                ", puntuacion=" + getPuntuacion() +
                '}';
    }


    @Override
    public double calcularDistancia(List coordenadasAtaque) {
        Integer x1 = getUbicacion().get(0);
        Integer x2 = (Integer) coordenadasAtaque.get(0);
        Integer y1 = getUbicacion().get(1);
        Integer y2 = (Integer) coordenadasAtaque.get(1);

        double distancia =
                Math.sqrt(
                        Math.pow((x1 - x2),2)
                                + Math.pow((y1 - y2),2));
        return distancia;
    }

    @Override
    public int calcularPuntaje() {
        return this.getPuntuacion();
    }


}

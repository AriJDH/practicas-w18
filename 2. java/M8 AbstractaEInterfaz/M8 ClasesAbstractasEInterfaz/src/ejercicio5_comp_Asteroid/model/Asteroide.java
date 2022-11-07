package ejercicio5_comp_Asteroid.model;

import java.util.List;

public class Asteroide {
    private String nombre; //nombre del asteroide
    private List<Integer> coordenadas; //coordenadas de cada asteroide

    public Asteroide() {
    }

    public Asteroide(String nombre, List<Integer> coordenadas) {
        this.nombre = nombre;
        this.coordenadas = coordenadas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Integer> getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(List<Integer> coordenadas) {
        this.coordenadas = coordenadas;
    }

    @Override
    public String toString() {
        return "Asteroide{" +
                "nombre='" + nombre + '\'' +
                ", coordenadas=" + coordenadas +
                '}';
    }


}

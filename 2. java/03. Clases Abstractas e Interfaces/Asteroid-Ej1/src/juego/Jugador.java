package juego;

import java.util.ArrayList;
import java.util.List;

public class Jugador implements Comparable<Jugador>{
    private String nombre;
    private AtackUnit unidadDeAtaque;
    private int puntuacion = 0;
    private List<Double> logDistancias = new ArrayList<>();

    public Jugador(String nombre, AtackUnit unit) {
        this.nombre = nombre;
        this.unidadDeAtaque = unit;
    }

    public AtackUnit getUnidadDeAtaque() {
        return unidadDeAtaque;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void sumarPuntaje(){
        this.puntuacion++;
    }

    public void agregarDistancia(double distancia){
        this.logDistancias.add(distancia);
    }

    @Override
    public String toString() {
        return "Jugador=" + this.nombre +
                "\n\tPuntaje=" + this.puntuacion +
                "\n\tUnits=" + this.unidadDeAtaque +
                "\n\tHistorial de ataques=" + this.logDistancias +
                "\n---------------------------------------------------\n";
    }

    @Override
    public int compareTo(Jugador j) {
        //mayor a menor
        return Integer.compare(j.puntuacion, this.puntuacion);
    }
}

package com.meli.lgutierrez.complementario.ejercicio2;

import java.util.List;

public class Nave implements Componente{

    private String nombre;
    private List<Integer> coordenadasNave;
    private int puntuacion;

    public Nave(String nombre, List<Integer> coordenadasNave) {
        this.nombre = nombre;
        this.coordenadasNave = coordenadasNave;
        this.puntuacion = 0;
    }

    @Override
    public double cercaniaAsteroide(List<Integer> coordenadasAsteroide) {
        return Math.sqrt(Math.pow((coordenadasNave.get(0) - coordenadasAsteroide.get(0)),2) + Math.pow((coordenadasNave.get(1) - coordenadasAsteroide.get(1)),2));
    }

      public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Integer> getCoordenadasNave() {
        return coordenadasNave;
    }

    public void setCoordenadasNave(List<Integer> coordenadasNave) {
        this.coordenadasNave = coordenadasNave;
    }

    @Override
    public int getPuntuacion() {
        return puntuacion;
    }

    @Override
    public void setPuntuacion(int puntuacion) {
        this.puntuacion += puntuacion;
    }

    @Override
    public String toString() {
        return "Nave: " + nombre + ". ";
    }
}

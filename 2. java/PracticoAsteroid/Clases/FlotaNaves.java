package Clases;

import Interfaces.INave;

import java.util.ArrayList;
import java.util.List;

public class FlotaNaves implements INave {
    private String nombre;
    private int puntuacion=0;
    private List<INave> flotaNaves;

    public FlotaNaves(String nombre) {
        this.nombre = nombre;
        this.flotaNaves = new ArrayList<>();
    }

    @Override
    public void add(INave nave) {
        this.flotaNaves.add(nave);
    }

    @Override
    public String getNombre() {
        return this.nombre;
    }

    @Override
    public void setPuntuacion() {
        this.puntuacion += 1;
    }

    @Override
    public int getPuntaje() {
        return this.puntuacion;
    }

    @Override
    public float calcularDistancia(int[] coord) {
        float promedio;
        float acumulador=0;
        for(INave nave : flotaNaves){
            acumulador += nave.calcularDistancia(coord);
        }
        promedio = acumulador/flotaNaves.size();

        return promedio;
    }
}

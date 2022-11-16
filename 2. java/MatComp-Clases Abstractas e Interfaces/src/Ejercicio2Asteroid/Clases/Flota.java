package Ejercicio2Asteroid.Clases;

import Ejercicio2Asteroid.Interfaces.INave;

import java.util.ArrayList;


public class Flota implements INave {

    private String nombre;
    private int puntuacion =0;
    private ArrayList<INave> flota;

    public Flota(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void add(INave nave) {
        flota.add(nave);
    }

    @Override
    public String getNombre() {
        return this.nombre;
    }

    @Override
    public void setPuntuacion() {
        puntuacion +=1;
    }

    @Override
    public int getPuntuacion() {
        return this.puntuacion;
    }

    @Override
    public float calcularDistancia(int[] coordenadas) {
        float promedio;
        float acumulador=0;
        for (INave nave: flota){
            acumulador+= nave.calcularDistancia(coordenadas);
        }
        promedio= acumulador/flota.size();

        return promedio;
    }
}

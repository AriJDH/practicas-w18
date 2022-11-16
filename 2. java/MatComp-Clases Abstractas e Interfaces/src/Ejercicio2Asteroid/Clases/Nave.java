package Ejercicio2Asteroid.Clases;

import Ejercicio2Asteroid.Interfaces.INave;
import Ejercicio2Asteroid.Main;

public class Nave implements INave {

    private String nombre;
    private int x;
    private int y;
    private int puntuacion = 0;

    public Nave(String nombre, int x, int y) {
        this.nombre = nombre;
        this.x = x;
        this.y = y;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    @Override
    public String toString() {
        return "Nave{" +
                "nombre='" + nombre + '\'' +
                ", x=" + x +
                ", y=" + y +
                ", puntuacion=" + puntuacion +
                '}';
    }

    @Override
    public void add(INave nave) {
        //NO EN NAVES SIMPLES
    }

    @Override
    public void setPuntuacion() {
        this.puntuacion += 1;
    }

    @Override
    public float calcularDistancia(int[] coordenadas) {
        float distancia;
        distancia= (float)Math.sqrt(Math.pow((x-coordenadas[0]),2)+ Math.pow((y-coordenadas[1]),2));
        return distancia;
    }

}

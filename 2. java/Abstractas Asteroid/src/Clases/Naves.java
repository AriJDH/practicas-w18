package Clases;

import Interfaces.INaves;
import static java.lang.Math. *;

public class Naves implements INaves {
    private String nombre;
    private int xnave;
    private int ynave;
    private double puntuacion=0;

    public Naves(String nombre, int xnave, int ynave) {
        this.nombre = nombre;
        this.xnave = xnave;
        this.ynave = ynave;
    }

    @Override
    public double calcularDistancia(int xBlanco, int yBlanco) {
        return sqrt(pow(xnave-xBlanco,2)+pow(ynave-yBlanco,2));
    }

    @Override
    public void setPuntuacion() {
        this.puntuacion += 1;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public String getCoordenadas(){
        return  "X: " + this.xnave + " Y: "+this.ynave;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getXnave() {
        return xnave;
    }
    public void setXnave(int xnave) {
        this.xnave = xnave;
    }

    public int getYnave() {
        return ynave;
    }

    public void setYnave(int ynave) {
        this.ynave = ynave;
    }

    public double getPuntuacion() {
        return puntuacion;
    }
}

package clases;

import interfaz.Moverse;

public abstract class Nave implements Moverse {
    public static int PUNTUACION_INICIAL = 0;
    private String nombre;
    private double ubicacion[];
    private int puntos;

    public Nave(String nombre) {
        this.nombre = nombre;
        setUbicacion();
        this.puntos = PUNTUACION_INICIAL;
    }

    private void setUbicacion(){
        this.ubicacion = new double[2];
        this.ubicacion[0] = Math.random()*100;
        this.ubicacion[1] = Math.random()*100;
    }

    public void sumarPunto(){
        this.puntos++;
    }
    public double getEjeX(){
        return this.ubicacion[0];
    }

    public double getEjeY(){
        return this.ubicacion[1];
    }

    @Override
    public String toString() {
        return  nombre;
    }

    public int getPuntos() {
        return puntos;
    }
}

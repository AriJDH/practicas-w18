package Clases;

import Interfaces.INave;

public class NaveSimple implements INave {
    private String nombre;
    private int x1;
    private int y1;
    private int puntuacion=0;

    public NaveSimple(String nombre, int x1, int y1){
        this.nombre = nombre;
        this.x1 = x1;
        this.y1 = y1;
    }

    @Override
    public void add(INave nave) {
        //No se implemente en las Naves Simples
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
        float distancia;
        distancia = (float) Math.sqrt(Math.pow((x1-coord[0]),2) + Math.pow((y1-coord[1]),2));
        return distancia;
    }
}

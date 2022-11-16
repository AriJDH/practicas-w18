package com.meli.lgutierrez.complementario.ejercicio2;

import java.util.List;

public class FlotaNaves implements Componente{

    private List<Componente> naves;
    private int puntuacion;

    public FlotaNaves(List<Componente> naves) {
        this.naves = naves;
        this.puntuacion = 0;
    }

    public void agregarNave(Componente nave){
        naves.add(nave);
    }

    public void removerNave(Componente nave){
        naves.remove(nave);
    }

    @Override
    public double cercaniaAsteroide(List<Integer> coordenadasAsteroide) {
        double promedio = 0;
        for (Componente nave : naves) {
            promedio += nave.cercaniaAsteroide(coordenadasAsteroide);
        }
        return promedio/naves.size();
    }

    public List<Componente> getNaves() {
        return naves;
    }

    public void setNaves(List<Componente> naves) {
        this.naves = naves;
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
        String respuesta = "";

        for (Componente nave : naves) {
            respuesta += nave.toString();
        }

        return "FlotaNaves {" + respuesta + "}";
    }
}

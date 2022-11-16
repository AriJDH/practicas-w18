package com.meli.lgutierrez.complementario.ejercicio1;

public abstract class Personal {

    private String nombre;

    public Personal(String nombre) {
        this.nombre = nombre;
    }

    public abstract void trabajar();

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

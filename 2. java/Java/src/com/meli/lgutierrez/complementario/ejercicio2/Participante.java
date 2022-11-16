package com.meli.lgutierrez.complementario.ejercicio2;

public class Participante {

    private String nombre;
    private Componente componente;

    public Participante(String nombre, Componente componente) {
        this.nombre = nombre;
        this.componente = componente;
    }

    public Componente getComponente() {
        return componente;
    }

    public void setComponente(Componente componente) {
        this.componente = componente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

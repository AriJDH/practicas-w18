package com.deportes.demo.entity;

public class Deporte {


    public Deporte(String nombre, String nivel) {
        super();
        this.nombre = nombre;
        this.nivel = nivel;
    }

    private String nombre;
    private String nivel;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }


}

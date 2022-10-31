package org.example.domain;

public abstract class Universitario {
    private String nombre;
    private String legajo;

    public Universitario(String nombre, String legajo) {
        this.nombre = nombre;
        this.legajo = legajo;
    }

    public void saludar(){
        System.out.println("Hola! Soy "+ nombre + " y mi legajo es "+ legajo);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLegajo() {
        return legajo;
    }

    public void setLegajo(String legajo) {
        this.legajo = legajo;
    }
}

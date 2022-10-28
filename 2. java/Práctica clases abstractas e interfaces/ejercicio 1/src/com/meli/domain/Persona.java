package com.meli.domain;

public abstract class Persona {
    private String nombre;

    public Persona(String nombre) {
        this.nombre = nombre;
    }

    public void confirmarOperacion(){
        System.out.println("Operación realizada por " + this.nombre);
    }
}

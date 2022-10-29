package com.company;

public abstract class Animal {
    private String tipo;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Animal(String tipo) {
        this.tipo = tipo;
    }

    public Animal() {
    }

    public abstract void sonido(String sonido);
    public abstract void comerAnimal(Animal a);
}

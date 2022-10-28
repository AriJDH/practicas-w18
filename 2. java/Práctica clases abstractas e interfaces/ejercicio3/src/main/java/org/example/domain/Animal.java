package org.example.domain;

public abstract class Animal {
    private String nombre;

    public Animal(String nombre) {
        this.nombre = nombre;
    }

    public void presentarse(){
        System.out.println("Buenas! Soy "+ this.nombre);
    }

    public abstract void decirEspecie();
    public abstract void emitirSonido();

    public abstract void comer();
}

package Ejercicio3Animales.Clases;

import Ejercicio3Animales.Interfaces.Carnivoro;

public class Gato extends Animal implements Carnivoro {
    private String nombre;

    public Gato(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Gato{" +
                "nombre='" + nombre + '\'' +
                '}';
    }

    @Override
    public void emitirSonido() {
        System.out.println("Miau miau miau");
    }

    @Override
    public void comer() {
        Carnivoro.comerCarne();
    }
}

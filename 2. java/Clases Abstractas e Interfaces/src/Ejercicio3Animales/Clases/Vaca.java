package Ejercicio3Animales.Clases;

import Ejercicio3Animales.Interfaces.Hervivoro;

public class Vaca extends Animal implements Hervivoro {
    private String nombre;

    public Vaca(String nombre) {
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
        return "Vaca{" +
                "nombre='" + nombre + '\'' +
                '}';
    }

    @Override
    public void emitirSonido() {
        System.out.println("Muuuu muuuu muuuu");
    }

    @Override
    public void comer() {
        Hervivoro.comerHierba();
    }
}

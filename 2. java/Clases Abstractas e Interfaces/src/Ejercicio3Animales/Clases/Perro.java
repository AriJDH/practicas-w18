package Ejercicio3Animales.Clases;

import Ejercicio3Animales.Interfaces.Carnivoro;

import java.util.Scanner;

public class Perro extends Animal implements Carnivoro {

    private String nombre;

    public Perro(String nombre) {
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
        return "Perro{" +
                "nombre='" + nombre + '\'' +
                '}';
    }

    @Override
    public void emitirSonido() {
        System.out.println("Guau guau guau ");
    }

    @Override
    public void comer() {
        Carnivoro.comerCarne();
    }
}

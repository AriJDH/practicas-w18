package Ejercicio3.Clases;

import Ejercicio3.Interfaces.Carnivoro;

public class Perro extends Animal implements Carnivoro {
    public Perro() {
    }

    @Override
    void sonido() {
        System.out.println("El perro hace Guauuu");
    }

    @Override
    public void comerCarne() {
        System.out.println("El perro come carne");
    }
}

package Ejercicio3.Clases;

import Ejercicio3.Interfaces.Carnivoro;

public class Gato extends Animal implements Carnivoro {
    public Gato() {
    }

    @Override
    void sonido() {
        System.out.println("El gato hace Miauuuuu");
    }

    @Override
    public void comerCarne() {
        System.out.println("El gato come carne");
    }
}

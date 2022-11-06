package org.example.models;

import org.example.Animal;
import org.example.Carnivoro;

public class Perro extends Animal implements Carnivoro {
    @Override
    public void emitirSonido() {
        System.out.println("Guau, guau");
    }

    @Override
    public void comerAnimal(String t) {
        if (t.equals("Vaca") || t.equals("Gato") || t.equals("Perro")) {
            comerCarne();
        } else {
            System.out.println("El perro es carnivoro y no come "  + t + ".");
        }
    }

    @Override
    public void comerCarne() {
        System.out.println("El perro es carnivoro y come carne.");
    }
}

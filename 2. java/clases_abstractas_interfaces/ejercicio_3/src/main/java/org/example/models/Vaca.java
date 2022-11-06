package org.example.models;

import org.example.Animal;
import org.example.Herbivoro;

public class Vaca extends Animal implements Herbivoro {


    @Override
    public void emitirSonido() {
        System.out.println("Muuuu, muuuu");
    }

    @Override
    public void comerAnimal(String t) {
        if (t.equals("Vaca") || t.equals("Gato") || t.equals("Perro")) {
            System.out.println("La vaca es herbivora y no come " + t + ".");
        } else {
            comerHierba();
        }
    }

    @Override
    public void comerHierba() {
        System.out.println("La vaca es herbivora y come hierba.");
    }
}

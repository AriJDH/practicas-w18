package org.example;

import org.example.domain.Animal;
import org.example.domain.Gato;
import org.example.domain.Perro;
import org.example.domain.Vaca;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Animal> animales = new ArrayList<>();
        Gato gato = new Gato("Garfield");
        animales.add(gato);
        Perro perro = new Perro("Clifford");
        animales.add(perro);
        Vaca vaca = new Vaca("Lola");
        animales.add(vaca);

        animales.stream().forEach(animal->animal.emitirSonido());
        animales.stream().forEach(animal -> animal.comer());

    }
}
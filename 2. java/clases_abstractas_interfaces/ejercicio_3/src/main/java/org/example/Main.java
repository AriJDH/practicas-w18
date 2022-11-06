package org.example;

import org.example.models.Gato;
import org.example.models.Perro;
import org.example.models.Vaca;

public class Main {
    public static void main(String[] args) {

        System.out.println("------ PERRO ------");
        Perro perro = new Perro();
        perro.emitirSonido();
        perro.comerCarne();
        perro.comerAnimal("Lechuga");
        perro.comerAnimal("Gato");

        System.out.println("\n------ GATO ------");
        Gato gato = new Gato();
        gato.emitirSonido();
        gato.comerCarne();
        gato.comerAnimal("Tomate");
        gato.comerAnimal("Perro");

        System.out.println("\n------ VACA ------");
        Vaca vaca = new Vaca();
        vaca.emitirSonido();
        vaca.comerHierba();
        vaca.comerAnimal("Perro");
        vaca.comerAnimal("Pasto");
    }
}
package com.company;

public class Main {

    public static void main(String[] args) {
        Animal gato = new Gato();
        Animal perro = new Perro();
        Animal vaca = new Vaca();

        gato.sonido("Miau");
        perro.sonido("Guau");
        vaca.sonido("Muu");

        gato.comerAnimal(gato);
        perro.comerAnimal(perro);
        vaca.comerAnimal(vaca);

    }
}

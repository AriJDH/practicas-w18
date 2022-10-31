package com.meli.lgutierrez.clase3.ejercicioPractico3;

public class Test {
    public static void main(String[] args) {
        Perro perro = new Perro();
        Gato gato = new Gato();
        Vaca vaca = new Vaca();

        perro.comerAnimal(perro);
        perro.emitirSonido();

        gato.comerAnimal(gato);
        gato.emitirSonido();

        vaca.comerAnimal(vaca);
        vaca.emitirSonido();

    }
}

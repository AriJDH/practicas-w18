package com.meli.lgutierrez.clase3.ejercicioPractico3;

public class Perro extends Animal implements Alimentacion <Perro>{
    @Override
    public void emitirSonido() {
        System.out.println("Soy un perro y hago guau");
    }

    @Override
    public void comerAnimal(Perro perro) {
        System.out.println("Soy un perro y soy carnívoro");
    }
}

package com.meli.lgutierrez.clase3.ejercicioPractico3;

public class Gato extends Animal implements Alimentacion<Gato>{
    @Override
    public void comerAnimal(Gato gato) {
        System.out.println("Soy un gato y soy carnívoro");
    }

    @Override
    public void emitirSonido() {
        System.out.println("Soy un gato y hago miau");
    }
}

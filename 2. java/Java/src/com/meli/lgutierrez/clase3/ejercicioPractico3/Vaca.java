package com.meli.lgutierrez.clase3.ejercicioPractico3;

public class Vaca extends Animal implements Alimentacion<Vaca>{
    @Override
    public void comerAnimal(Vaca vaca) {
        System.out.println("Soy una vaca y soy hervíbora");
    }

    @Override
    public void emitirSonido() {
        System.out.println("Soy una vaca y hago muu");
    }
}

package Clases;

import Interfaces.Carnivoro;

public class Perro extends Animal implements Carnivoro {
    @Override
    public void emitirSonido() {
        System.out.println("Guau Guau!!");
    }

    @Override
    public void comer() {
        System.out.println("Comiendo carne...");
    }

    @Override
    public void comerCarne() {
        System.out.println("Comiendo carne...");
    }
}

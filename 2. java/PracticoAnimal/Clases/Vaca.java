package Clases;

import Interfaces.Herviboro;

public class Vaca extends Animal implements Herviboro {
    @Override
    public void emitirSonido() {
        System.out.println("Muuuuuuuuu!");
    }

    @Override
    public void comer() {
        System.out.println("Comiendo hierbas...");
    }

    @Override
    public void comerHierba() {
        System.out.println("Comiendo hierbas...");
    }
}

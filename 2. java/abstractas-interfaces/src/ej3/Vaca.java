package ej3;

public class Vaca extends Animal implements Herviboro {
    public Vaca() {
        super("Vaca");
    }

    @Override
    public void emitirSonido() {
        System.out.println("muuu");
    }

    @Override
    public void comerHierba() {
        System.out.println("Comer hierba");
    }
}

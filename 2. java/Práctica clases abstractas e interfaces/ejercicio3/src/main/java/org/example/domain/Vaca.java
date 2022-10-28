package org.example.domain;

public class Vaca extends Animal implements Herviboro{
    public Vaca(String nombre) {
        super(nombre);
    }

    @Override
    public void decirEspecie() {
        System.out.println("Soy una vaca");
    }

    @Override
    public void emitirSonido() {
        this.presentarse();
        this.decirEspecie();
        System.out.println("MUUUUUUUUUUUUUUUUU");
    }

    @Override
    public void comer() {
       super.presentarse();
       this.decirEspecie();
       this.comerHierba();
    }
}

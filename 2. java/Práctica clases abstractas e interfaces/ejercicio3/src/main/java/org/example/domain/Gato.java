package org.example.domain;

public class Gato extends Animal implements Carnivoro{
    public Gato(String nombre) {
        super(nombre);
    }

    @Override
    public void decirEspecie() {
        System.out.println("Soy un gato");
    }

    @Override
    public void emitirSonido() {
        super.presentarse();
        this.decirEspecie();
        System.out.println("MIAAAAAAAAAUUUUUUU");
    }

    @Override
    public void comer() {
        super.presentarse();
        this.decirEspecie();
        this.comerCarne();
    }
}

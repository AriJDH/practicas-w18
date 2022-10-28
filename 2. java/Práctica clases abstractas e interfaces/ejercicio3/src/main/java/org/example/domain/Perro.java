package org.example.domain;

public class Perro extends Animal implements Carnivoro{
    public Perro(String nombre) {
        super(nombre);
    }

    @Override
    public void decirEspecie() {
        System.out.println("Soy un perro");
    }

    @Override
    public void emitirSonido() {
        super.presentarse();
        this.decirEspecie();
        System.out.println("GUAU GUAU GUAU!!!!");
    }

    @Override
    public void comer() {
        super.presentarse();
        this.decirEspecie();
        this.comerCarne();
    }
}

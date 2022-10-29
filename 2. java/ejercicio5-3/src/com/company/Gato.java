package com.company;

public class Gato extends Animal implements Carnivoro{

    public Gato(String tipo) {
        super(tipo);
    }

    public Gato() {
        super();
    }

    @Override
    public void sonido(String sonido) {
        System.out.println("Soun un GATO y mi sonido es: " + sonido);
    }

    @Override
    public void comerAnimal(Animal a) {
        comerCarne();
    }

    @Override
    public void comerCarne() {
        System.out.println("Como CARNE");
    }
}

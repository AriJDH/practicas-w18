package com.company;

public class Perro extends Animal implements Carnivoro{
    public Perro(String tipo) {
        super(tipo);
    }

    public Perro() {
    }

    @Override
    public void sonido(String sonido) {
        System.out.println("Soun un PERRO y mi sonido es: " + sonido);
    }

    @Override
    public void comerCarne() {
        System.out.println("Como CARNE");
    }
    @Override
    public void comerAnimal(Animal a) {
comerCarne();
    }
}

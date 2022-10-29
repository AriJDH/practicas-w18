package com.company;

public class Vaca extends Animal implements Herviboro{
    public Vaca(String tipo) {
        super(tipo);
    }

    public Vaca() {
    }

    @Override
    public void sonido(String sonido) {
        System.out.println("Soun una VACA y mi sonido es: " + sonido);
    }


    @Override
    public void comerHierba() {
        System.out.println("Como HIRBAS");
    }
    @Override
    public void comerAnimal(Animal a) {
comerHierba();
    }
}

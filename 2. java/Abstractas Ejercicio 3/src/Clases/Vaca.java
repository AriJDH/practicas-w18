package Clases;

import Interfaces.comerHierba;

public class Vaca extends Animal implements comerHierba {
    static final String tipo= "Vaca";

    @Override
    public String hacerSonido() {
        return "Muu";
    }

    @Override
    public String comerAnimal(Animal animal) {
        return comerHierba();
    }
}

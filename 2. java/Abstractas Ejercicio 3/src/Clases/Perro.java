package Clases;

import Interfaces.comerCarne;

public class Perro extends Animal implements comerCarne {

    static final String tipo= "Perro";

    @Override
    public String hacerSonido() {
        return "Guau";
    }

    @Override
    public String comerAnimal(Animal animal) {
        return comerCarne();
    }
}

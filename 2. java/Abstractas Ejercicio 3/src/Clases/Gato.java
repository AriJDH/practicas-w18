package Clases;

import Interfaces.comerCarne;

public class Gato extends Animal implements comerCarne {
    static final String tipo= "Gato";

    @Override
    public String hacerSonido() {
        return "Miau";
    }

    @Override
    public String comerAnimal(Animal animal) {
        return comerCarne();
    }
}

package subclases;

import superclase.Animales;

public class Gato extends Animales {
    @Override
    public void emitirSonido() {
        System.out.println("¡Miau!");
    }
}

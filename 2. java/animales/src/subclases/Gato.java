package subclases;

import interfaces.Carniboro;
import superclase.Animales;

public class Gato extends Animales implements Carniboro {
    @Override
    public void emitirSonido() {
        System.out.println("¡Miau!");
    }

    @Override
    public void comerCarne() {
        System.out.println("El gato está comiendo carne");
    }
}

package subclases;

import interfaces.Carniboro;
import superclase.Animales;

public class Perro extends Animales implements Carniboro {


    @Override
    public void emitirSonido() {
        System.out.println("¡Guau!");
    }

    @Override
    public void comerCarne() {
        System.out.println("El perro está comiendo carne");
    }
}

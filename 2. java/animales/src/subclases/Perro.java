package subclases;

import superclase.Animales;

public class Perro extends Animales {


    @Override
    public void emitirSonido() {
        System.out.println("¡Guau!");
    }
}

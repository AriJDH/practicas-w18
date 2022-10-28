package subclases;

import superclase.Animales;

public class Vaca extends Animales {

    @Override
    public void emitirSonido() {
        System.out.println("Muuu!");
    }
}

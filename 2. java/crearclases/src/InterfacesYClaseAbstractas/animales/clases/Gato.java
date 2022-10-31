package InterfacesYClaseAbstractas.animales.clases;

import InterfacesYClaseAbstractas.animales.interfaces.Carnivoro;

public class Gato extends Animales implements Carnivoro {
    public Gato(double altura, double peso, String raza) {
        super(altura, peso, raza);
    }

    @Override
    public void emitirSonido() {
        System.out.println("miauuu");
    }

    @Override
    public void comerAnimal() {
        comerCarne();
    }

    @Override
    public void comerCarne() {
        System.out.println("el gato come carne");
    }
}

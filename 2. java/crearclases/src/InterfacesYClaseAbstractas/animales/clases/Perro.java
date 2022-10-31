package InterfacesYClaseAbstractas.animales.clases;

import InterfacesYClaseAbstractas.animales.interfaces.Carnivoro;

public class Perro extends Animales implements Carnivoro {
    public Perro(double altura, double peso, String raza) {
        super(altura, peso, raza);
    }

    @Override
    public void emitirSonido() {
        System.out.println("guaaauuuu");
    }

    @Override
    public void comerAnimal() {
        comerCarne();
    }

    @Override
    public void comerCarne() {
        System.out.println("el perro come carne");
    }
}

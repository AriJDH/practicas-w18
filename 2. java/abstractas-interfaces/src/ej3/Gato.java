package ej3;

public class Gato extends Animal implements Carnivoro {
    public Gato() {
        super("Gato");
    }

    @Override
    public void emitirSonido() {
        System.out.println("miau");
    }

    @Override
    public void comerCarne() {
        System.out.println("Comer carne");
    }

    @Override
    public void comerAnimal(Animal a) {
        System.out.println("Comiendo un " + a.getEspecie());

    }
}

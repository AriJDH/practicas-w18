public class Gato extends Animal implements Carnivoro {
    @Override
    void emitirSonido() {
        System.out.println("Meow");
    }

    @Override
    void comerAnimal() {
        this.comerCarne();
    }

    @Override
    public void comerCarne() {
        System.out.println("Mmm, gato come carne");
    }
}

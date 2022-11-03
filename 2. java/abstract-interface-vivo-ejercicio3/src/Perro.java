public class Perro extends Animal implements Carnivoro {
    @Override
    void emitirSonido() {
        System.out.println("Woof");
    }

    @Override
    public void comerAnimal() {
        this.comerCarne();
    }

    @Override
    public void comerCarne() {
        System.out.println("Mmm, perro come carne");
    }
}

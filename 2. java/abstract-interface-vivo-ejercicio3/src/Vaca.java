public class Vaca extends Animal implements Herbivoro{
    @Override
    void emitirSonido() {
        System.out.println("Moo");
    }

    @Override
    void comerAnimal() {
        this.comerHierba();
    }

    @Override
    public void comerHierba() {
        System.out.println("Mmm, vaca come hierba");
    }
}

public class Vaca extends Animal implements Herbivoro{
    @Override
    public void emitirSonido() {
        System.out.println("Muuuu");
    }

    @Override
    public void comerAnimal() {
        comerHierba();
    }

    @Override
    public void comerHierba() {
        Herbivoro.super.comerHierba();
    }
}

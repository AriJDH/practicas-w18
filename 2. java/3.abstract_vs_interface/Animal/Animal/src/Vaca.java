import interfaces.Herviboro;

public class Vaca extends Animal implements Herviboro {
    @Override
    public void emitirSonido() {
        System.out.println("MUUUUUU");
    }

    @Override
    public void comerAnimal(Animal animal) {
        if (animal == Vaca.this){
            emitirSonido();
            comerHierba();
        }
    }

    @Override
    public void comerHierba() {
        System.out.println("Soy una vaca y como pasto");
    }
}

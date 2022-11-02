import interfaces.Herviboro;

public class Vaca extends Animal implements Herviboro {
    @Override
    public void emitirSonido() {
        System.out.println("Muuuuu");
    }
}

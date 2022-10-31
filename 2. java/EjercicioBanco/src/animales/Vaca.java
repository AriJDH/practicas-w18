package animales;

public class Vaca extends Animal implements ComerHierba{

    @Override
    public void emitirSonido() {
        System.out.println("Las vacas emitimos sonidos como: Muuuu muuuu....");
    }

    @Override
    public void comerHierba() {
        System.out.println("Las vacas comemos hierbas");
    }
}

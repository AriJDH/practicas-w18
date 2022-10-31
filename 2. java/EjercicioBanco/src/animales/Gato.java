package animales;

public class Gato extends Animal implements ComerCarne{

    @Override
    public void emitirSonido() {
        System.out.println("Los gatos emitimos sonidos como: Miau miau....");
    }

    @Override
    public void comerCarne() {
        System.out.println("Los gatos comemos carne");
    }
}

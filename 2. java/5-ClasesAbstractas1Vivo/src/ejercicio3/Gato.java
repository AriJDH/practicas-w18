package ejercicio3;

public class Gato extends Animal implements ComerCarne {
    @Override
    public void emitirSonido() {
        System.out.println("Miau");
    }

    @Override
    public void comerCarne() {
        System.out.println("Los gatos comemos carne");
    }


}

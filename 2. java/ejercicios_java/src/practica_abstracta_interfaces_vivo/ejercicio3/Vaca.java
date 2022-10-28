package practica_abstracta_interfaces_vivo.ejercicio3;

public class Vaca extends Animal implements IAlimentacionAnimal {

    @Override
    public void emitirSonido() {
        System.out.println("Muuuu");
    }

    @Override
    public void comerCarne() {
        System.out.println("No come carne");
    }

    @Override
    public void comerHierba() {
        System.out.println("Come hierba");
    }
}

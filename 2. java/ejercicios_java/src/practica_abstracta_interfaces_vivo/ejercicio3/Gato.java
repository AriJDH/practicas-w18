package practica_abstracta_interfaces_vivo.ejercicio3;

public class Gato extends Animal implements IAlimentacionAnimal {

    @Override
    public void emitirSonido() {
        System.out.println("Miauu");
    }

    @Override
    public void comerCarne() {
        System.out.println("Come carne");
    }

    @Override
    public void comerHierba() {
        System.out.println("Come hierba");
    }
}

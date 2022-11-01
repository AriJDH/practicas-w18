package ejercicio_3;

public class Gato extends Animal implements Carnivoro{

    @Override
    void emitirSonido() {
        System.out.println("Miau");
    }

    @Override
    public void comerCarne() {
        System.out.println("Comiendo atún! Nom Nom Nom");
    }

    @Override
    void comer() {
        comerCarne();
    }
}

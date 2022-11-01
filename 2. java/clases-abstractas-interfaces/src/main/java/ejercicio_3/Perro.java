package ejercicio_3;

public class Perro extends Animal implements Carnivoro{

    @Override
    void emitirSonido() {
        System.out.println("Guau");
    }

    @Override
    public void comerCarne() {
        System.out.println("Comiendo Carne Nom Nom");
    }

    @Override
    void comer() {
        comerCarne();
    }
}

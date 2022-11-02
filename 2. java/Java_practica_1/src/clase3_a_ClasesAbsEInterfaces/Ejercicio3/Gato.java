package clase3_a_ClasesAbsEInterfaces.Ejercicio3;

public class Gato extends Animal implements Carnivoro{
    @Override
    public void emitirSonidos() {
        System.out.println("Miauuu!");
    }

    @Override
    public void comerCarne() {
        System.out.println("Comiendo carne...");
    }

    @Override
    public void comer() {
        this.comerCarne();
    }
}

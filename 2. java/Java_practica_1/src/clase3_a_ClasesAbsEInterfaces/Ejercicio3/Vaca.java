package clase3_a_ClasesAbsEInterfaces.Ejercicio3;

public class Vaca extends Animal implements Herviboro{
    @Override
    public void emitirSonidos() {
        System.out.println("muuuu!");
    }

    @Override
    public void comerHierba() {
            System.out.println("Comiendo hierva...");
    }

    @Override
    public void comer() {
        this.comerHierba();
    }
}

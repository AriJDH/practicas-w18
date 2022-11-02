package animales;

public class Vaca extends Animal implements Hervivoro{
    public Vaca(String nombre) {
        super(nombre);
    }

    @Override
    public void emitirSonido() {
        System.out.println("Muuuuuuuuuu...");
    }

    @Override
    protected void comer() {
        this.comerHierba();
    }
}

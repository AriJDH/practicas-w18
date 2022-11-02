package animales;

public class Perro extends Animal implements Carnivoro{

    public Perro(String nombre) {
        super(nombre);
    }

    @Override
    public void emitirSonido() {
        System.out.println("Guau!");
    }

    @Override
    protected void comer() {
        this.comerCarne();
    }

}

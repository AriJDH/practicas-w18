package ejercicio3;

public class Gato extends Animal{
    public Gato() {
        super();
        this.gusto= new Carnivoro();
    }

    @Override
    public String emitirSonido() {
        return "Miau";
    }

    @Override
    public void comer() {
        this.gusto.comer();
    }
}

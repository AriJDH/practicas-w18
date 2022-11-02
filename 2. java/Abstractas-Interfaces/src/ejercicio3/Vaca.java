package ejercicio3;

public class Vaca extends Animal{
    public Vaca() {
        super();
        this.gusto= new Hervivoro();
    }

    @Override
    public String emitirSonido() {
        return "Muuu";
    }

    @Override
    public void comer() {
        this.gusto.comer();
    }
}

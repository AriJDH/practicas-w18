package ejercicio3;

public class Perro extends Animal{

    private String nombre;

    public Perro(String nombre) {
        super();
        this.gusto= new Carnivoro();
        this.nombre = nombre;
    }

    @Override
    public String emitirSonido() {
        return "Guau";
    }

    @Override
    public void comer() {
        this.gusto.comer();
    }
}

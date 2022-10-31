package InterfacesYClaseAbstractas.animales.clases;

public abstract class Animales {
    private double altura;
    private double peso;
    private String raza;

    public Animales(double altura, double peso, String raza) {
        this.altura = altura;
        this.peso = peso;
        this.raza = raza;
    }

    public void emitirSonido() {
        System.out.println("hacer un sonido");
    }

    public double getAltura() {
        return altura;
    }

    public double getPeso() {
        return peso;
    }

    public String getRaza() {
        return raza;
    }

    public void comerAnimal() {
        System.out.println("lo que come este animal");
    }
}

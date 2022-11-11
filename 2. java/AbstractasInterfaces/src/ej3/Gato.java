package ej3;

public class Gato extends Animal implements Carnivoro{
    private String raza;

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public Gato(String nombre, float peso, float edad, String raza) {
        super(nombre, peso, edad);
        this.raza = raza;
    }

    @Override
    public String hacerSonido() {
        return "Miau";
    }

    @Override
    public String comerCarne() {
        return "Comiendo carne";
    }
}

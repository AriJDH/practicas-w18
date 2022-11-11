package ej3;

public class Perro extends Animal implements Carnivoro{
    private String raza;

    public Perro(String nombre, float peso, float edad, String raza) {
        super(nombre, peso, edad);
        this.raza = raza;
    }

    @Override
    public String hacerSonido() {
        return "Guau";
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    @Override
    public String comerCarne() {
        return "Comiendo carne";
    }
}

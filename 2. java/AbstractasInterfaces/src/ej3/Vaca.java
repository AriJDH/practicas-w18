package ej3;

public class Vaca extends Animal implements Herbivoro{
    public Vaca(String nombre, float peso, float edad) {
        super(nombre, peso, edad);
    }

    @Override
    public String hacerSonido() {
        return "Muuu";
    }

    @Override
    public String comerHierba() {
        return "Comiendo pastito";
    }
}

package ClasesAbstractas_e_Interfaces.Ejercicio3.Animales;

public abstract class Animal {
    private String especie;

    public Animal(String especie) {
        this.especie = especie;
    }

    public abstract void emitirSonido();

    public String getEspecie() {
        return especie;
    }
}

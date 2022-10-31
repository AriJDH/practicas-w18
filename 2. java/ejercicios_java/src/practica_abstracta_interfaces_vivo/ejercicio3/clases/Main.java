package practica_abstracta_interfaces_vivo.ejercicio3.clases;

public class Main {

    public static void main(String[] args) {
        Perro perro = new Perro();
        perro.emitirSonido();
        perro.comerCarne();

        Gato gato = new Gato();
        gato.emitirSonido();
        gato.comerCarne();

        Vaca vaca = new Vaca();
        vaca.emitirSonido();
        vaca.comerCarne();

        comerAnimal(perro);
    }

    /**
     * Metodo que a partir de cualquier tipo de animal muestra su correspondiente alimentacion
     * haciendo uso del polimorfismo
     * @param animal objeto que puede ser cualquier animal
     */
    private static void comerAnimal(Animal animal) {
        animal.comerAnimal();
    }
}

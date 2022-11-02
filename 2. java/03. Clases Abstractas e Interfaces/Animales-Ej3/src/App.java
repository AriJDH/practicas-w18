import animales.Animal;
import animales.Gato;
import animales.Perro;
import animales.Vaca;

public class App {
    public static void main(String[] args) {
        Animal perro = new Perro("Dobby");
        Animal gato = new Gato("Luna");
        Animal vaca = new Vaca("Betsy");

        Animal.comerAnimal(perro);
        Animal.comerAnimal(gato);
        Animal.comerAnimal(vaca);

        perro.emitirSonido();
        gato.emitirSonido();
        vaca.emitirSonido();
    }
}

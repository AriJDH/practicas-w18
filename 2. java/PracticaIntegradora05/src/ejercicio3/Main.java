package ejercicio3;

import ejercicio3.model.Animal;
import ejercicio3.model.Gato;
import ejercicio3.model.Perro;
import ejercicio3.model.Vaca;

public class Main {

    public static void main(String[] args) {


        Gato animal1 = new Gato();
        animal1.emitirSonido();
        animal1.comerCarne();

        System.out.println();

        Vaca animal2 = new Vaca();
        animal2.emitirSonido();
        animal2.comerHierba();

        System.out.println();

        Perro animal3 = new Perro();
        animal3.emitirSonido();
        animal3.comer();

        System.out.println();

        Animal.comerAnimal(animal1);
        Animal.comerAnimal(animal2);
        Animal.comerAnimal(animal3);

    }

}

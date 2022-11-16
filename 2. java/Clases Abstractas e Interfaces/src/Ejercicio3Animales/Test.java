package Ejercicio3Animales;

import Ejercicio3Animales.Clases.Gato;
import Ejercicio3Animales.Clases.Perro;
import Ejercicio3Animales.Clases.Vaca;
import Ejercicio3Animales.Interfaces.ComerAnimal;

public class Test {
    public static void main(String[] args) {

        a
        Perro perro1 = new Perro("Tobi");
        perro1.emitirSonido();
        perro1.comer();

        Gato gato1 = new Gato("Michi");
        gato1.emitirSonido();
        gato1.comer();

        Vaca vaca1 = new Vaca("Aurelia");
        vaca1.emitirSonido();
        vaca1.comer();

        ComerAnimal.comerAnimal(perro1);
        ComerAnimal.comerAnimal(gato1);
        ComerAnimal.comerAnimal(vaca1);
    }
}

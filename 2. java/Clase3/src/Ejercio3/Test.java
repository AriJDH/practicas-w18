package Ejercio3;

import java.util.LinkedList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Perro perro1 = new Perro("Perro");
        Gato gato1 = new Gato("Gato");
        Vaca vaca1 = new Vaca("Vaca");
        List<Animal> lista = new LinkedList<>();
        lista.add(perro1);
        lista.add(gato1);
        lista.add(vaca1);

        for(Animal animal : lista){
            animal.emitirSonido();
            if(animal instanceof Carnivoro){
                animal.comerAnimal(vaca1);
            }
            if(animal instanceof Herviboro){
                animal.comerAnimal(perro1);
            }
        }
    }
}

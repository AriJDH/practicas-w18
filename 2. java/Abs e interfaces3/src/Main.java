import clases.Animal;
import clases.Gato;
import clases.Perro;
import clases.Vaca;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Animal> animales = new ArrayList<>();

        animales.add(new Gato());
        animales.add(new Perro());
        animales.add(new Vaca());

        Vaca vaca = new Vaca();
        Gato gato = new Gato();
        Perro perro = new Perro();

        vaca.comer();
        gato.comer();
        perro.comer();

       for(Animal anim :animales){
           anim.sonar();
       }

        vaca.comerAnimal(gato);
        gato.comerAnimal(perro);
        perro.comerAnimal(vaca);
    }
}
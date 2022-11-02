package ejercicio3_Animal;

import ejercicio3_Animal.Intefaz.AnimalDiet;
import ejercicio3_Animal.Model.Animal;
import ejercicio3_Animal.Model.Cat;
import ejercicio3_Animal.Model.Cow;
import ejercicio3_Animal.Model.Dog;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Animal perro = new Dog();
        Animal gato = new Cat();
        Animal vaca = new Cow();

        ArrayList<Animal> animals = new ArrayList<>();

        animals.add(perro);
        animals.add(gato);
        animals.add(vaca);

        for (Animal a: animals) {
            a.makeSound();
            //a.diet();
            AnimalDiet.eatAnimal(a);

        }



    }
}

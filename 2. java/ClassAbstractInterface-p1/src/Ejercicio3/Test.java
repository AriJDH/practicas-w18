package Ejercicio3;

import Ejercicio3.model.Cat;
import Ejercicio3.model.Cow;
import Ejercicio3.model.Dog;

public class Test {

    public static void main(String[] args) {
        Cat cat=new Cat();
        Cow cow=new Cow();
        Dog dog=new Dog();

        System.out.println("cat");
        cat.emitirSonido();
        cat.eatAnimal(cat);

        System.out.println("cow");
        cow.emitirSonido();
        cow.eatAnimal(cow);

        System.out.println("dog");
        dog.emitirSonido();
        dog.eatAnimal(dog);

    }


}

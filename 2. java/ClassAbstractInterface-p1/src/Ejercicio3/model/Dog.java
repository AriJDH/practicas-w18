package Ejercicio3.model;

import Ejercicio3.Abstract.Animal;
import Ejercicio3.Interface.Carnivorous;
import Ejercicio3.Util.CheckAnimal;

public class Dog extends Animal implements Carnivorous {
    public Dog() {
    }

    @Override
    public void emitirSonido() {
        System.out.println("Guau!, Guau!, Guau!...");
    }

    @Override
    public <T> void eatAnimal(T t) {
        if (CheckAnimal.checkingAnimal(t.toString())){
            eatMeat();
        }
    }

    @Override
    public void eatMeat() {
        System.out.println(toString()+" Comiendo carne");
    }

    @Override
    public String toString() {
        return "Dog";
    }
}

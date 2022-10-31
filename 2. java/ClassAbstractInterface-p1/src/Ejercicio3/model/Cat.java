package Ejercicio3.model;

import Ejercicio3.Abstract.Animal;
import Ejercicio3.Interface.Carnivorous;
import Ejercicio3.Util.CheckAnimal;

public class Cat extends Animal implements Carnivorous {
    public Cat() {
    }

    @Override
    public void emitirSonido() {
        System.out.println("Miau, miau, miau...");
    }

    @Override
    public <T> void eatAnimal(T t) {

        if (CheckAnimal.checkingAnimal(t.toString())){
            eatMeat();
        }
    }

    @Override
    public void eatMeat() {
        System.out.println(toString()+" comiendo como carnívoro.");
    }

    @Override
    public String toString() {
        return "Cat";
    }
}

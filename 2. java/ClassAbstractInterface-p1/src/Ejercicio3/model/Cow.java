package Ejercicio3.model;

import Ejercicio3.Abstract.Animal;
import Ejercicio3.Interface.Herbivorous;
import Ejercicio3.Util.CheckAnimal;

public class Cow extends Animal implements Herbivorous {
    @Override
    public void emitirSonido() {
        System.out.println("Muuuuuuuu!!!!!!");
    }

    @Override
    public <T> void eatAnimal(T t) {

        if (!CheckAnimal.checkingAnimal(t.toString())){
            eatGrass();
        }
    }

    public Cow() {
    }

    @Override
    public void eatGrass() {
        System.out.println(toString()+" Comiendo como herbívoro.");
    }

    @Override
    public String toString() {
        return "Cow";
    }
}

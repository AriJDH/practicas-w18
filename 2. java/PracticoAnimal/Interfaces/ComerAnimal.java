package Interfaces;

import Clases.Animal;

public interface ComerAnimal {

    static void comerAnimal(Animal animal){
        animal.comer();
    }
}

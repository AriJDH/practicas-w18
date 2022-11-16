package Ejercicio3Animales.Interfaces;

import Ejercicio3Animales.Clases.Animal;

public interface ComerAnimal {
    static void comerAnimal(Animal animal){
        animal.comer();
    }
}

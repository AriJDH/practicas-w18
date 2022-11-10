package Interfaces;

import Clases.Animal;

public interface comerCarne {
    public default String comerCarne(){
        return "Comiendo carne";
    };
    public abstract String comerAnimal(Animal animal);

}

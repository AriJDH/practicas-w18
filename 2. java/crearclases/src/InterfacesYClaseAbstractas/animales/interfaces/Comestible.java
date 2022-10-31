package InterfacesYClaseAbstractas.animales.interfaces;

import InterfacesYClaseAbstractas.animales.clases.Animales;

public interface Comestible {
    static void comer(Animales animal){
        animal.comerAnimal();
    }
};
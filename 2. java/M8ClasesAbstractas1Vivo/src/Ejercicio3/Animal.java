package Ejercicio3;

public abstract class Animal implements ComerAnimal{
    public abstract void emitirSonido();

    public void comerAnimal(Animal animal){
        if(animal instanceof Perro){
            ((Perro) animal).comerCarne();
        } else if(animal instanceof Gato){
            ((Gato) animal).comerCarne();
        } else if(animal instanceof Vaca){
            ((Vaca) animal).comerHierba();
        }
    }
}

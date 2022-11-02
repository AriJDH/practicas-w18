package ejercicio3_Animal.Intefaz;

public interface Herbivorous<T> extends AnimalDiet{
    default void diet(){
        System.out.println("The " + getClass().getSimpleName() + " is herbivorous");
    }

}

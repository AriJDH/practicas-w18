package ejercicio3_Animal.Intefaz;

public interface Carnivorous <T> extends AnimalDiet{
    default void diet(){
        System.out.println("The " + getClass().getSimpleName() + " is carnivorous");
    }

}

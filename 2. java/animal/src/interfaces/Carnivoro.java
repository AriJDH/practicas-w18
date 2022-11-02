package interfaces;

public interface Carnivoro {

    default void comerCarne(){
        System.out.println("Soy un animal que come carne");
    }
}

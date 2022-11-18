package ejercicio3.interfaces;

public interface AlimentableAnimal {
    default void comerAnimal(String tipo){
        System.out.println("Este '"+getClass().getSimpleName()+"' puede comer animales como el '"+tipo+"'");
    }
}

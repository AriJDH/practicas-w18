package ejercicio3.interfaces;

public interface AlimentableCarne {
    default void comerCarne(){
        System.out.println("Este '"+getClass().getSimpleName()+"' tiene su alimentación a base de carne");
    };
}

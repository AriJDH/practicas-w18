package ejercicio3.interfaces;

public interface AlimentableHierba {
    default void comerHierba(){
        System.out.println("Este '"+getClass().getSimpleName()+"' tiene su alimentación a base de hierbas");
    };
}

package Ejercicio1.Interface;

public interface Transaccionable<T> {
    default  void transaccionOk(String tipoOperacion){
        System.out.println("La operación "+tipoOperacion+" fue exitosa!");
    }
     default void transaccionNoOk(String tipoOperacion){
         System.out.println("La operación "+tipoOperacion+ "falló.");
     }
}

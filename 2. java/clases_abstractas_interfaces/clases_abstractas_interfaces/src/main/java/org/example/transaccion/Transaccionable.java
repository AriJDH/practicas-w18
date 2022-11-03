package org.example.transaccion;

public interface Transaccionable<T> {

    default void transaccionOk(String T){
        System.out.println("Se realizó la operación " + T + " con éxito. Gracias por utilizar nuestro servicio.");
    };

    default void transaccionNoOk(String T){
        System.out.println("La operación " + T + " falló. Reintente nuevamente.");
    }
}

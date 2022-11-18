package ejercicio1.interfaces;

public interface Transaccionable {
    default void transaccionOK(String tipo){
        System.out.println("La operación '"+tipo+"' se realizó correctamente"+" en la cuenta bancaria de tipo "+getClass().getSimpleName());
    }
    default void transaccionNoOk(String tipo){
        System.out.println("La operación '"+tipo+"' no pudo ser realizada"+" en la cuenta bancaria de tipo "+getClass().getSimpleName());
    }
}

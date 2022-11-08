public interface Transaccion {

    default void transaccionOK(){
        System.out.println("Transaccion realizada exitosamente...");
    }

    default void transaccionNoOk(){
        System.out.println("Transaccion no realizada...");
    }

}

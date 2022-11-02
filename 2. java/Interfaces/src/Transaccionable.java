public interface Transaccionable {
    default void tansaccionOk(){
        System.out.println("La transaccion fue realizada con exito");
    }
    default void transaccionNoOk(){
        System.out.println("La transaccion no pudo ser realizada");
    }
}

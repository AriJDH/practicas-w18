package banco.operaciones;

public interface Transferencia extends Transaccion{
    default void transferir(){
        System.out.println("Realizando Transferencia.");
    }
}

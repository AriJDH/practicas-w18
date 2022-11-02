package banco.operaciones;

public interface ConsultaSaldo extends Transaccion {
    default void consultarSaldo(){
        System.out.println("Consultando Saldo.");
    }
}

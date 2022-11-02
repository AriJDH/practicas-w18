package banco.clientes;

import banco.operaciones.Deposito;
import banco.operaciones.Transferencia;

public class Ejecutivo extends Cliente implements Deposito, Transferencia {
    @Override
    public void transaccionOk() {
        System.out.println("Operación Realizada con éxito.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Operación Fallida!");
    }
}

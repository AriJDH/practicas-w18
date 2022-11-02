package interfaces;

import interfaces.Transaccion;

public interface Transferencia extends Transaccion {

    public void realizarTransferencia(double importe);

}

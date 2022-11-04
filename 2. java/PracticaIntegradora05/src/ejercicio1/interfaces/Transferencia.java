package ejercicio1.interfaces;

public interface Transferencia extends ITransaccion {

    void hacerTransferencia(int montoTransferencia, String idCliente);
}

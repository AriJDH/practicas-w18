package InterfacesYClaseAbstractas.banco.interfaces;

public interface Transferencia extends Transacciones{

    public void hacerTransferencia(String destinatario, double monto);
}

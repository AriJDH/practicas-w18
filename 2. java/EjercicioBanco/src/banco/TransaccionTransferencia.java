package banco;

public interface TransaccionTransferencia extends Transaccion {
    @Override
    void transaccionOK();

    @Override
    void transaccionNoOk();
}

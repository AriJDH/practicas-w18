package Ejercicio1;

public interface TransaccionTransferencia extends Transaccion{
    @Override
    void transaccionOk();

    @Override
    void transaccionNoOk();
}

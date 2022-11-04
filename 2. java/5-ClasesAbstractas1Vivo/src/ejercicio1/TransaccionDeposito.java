package ejercicio1;

public interface TransaccionDeposito extends Transaccion{
    @Override
    void transaccionOk();

    @Override
    void transaccionNoOk();
}

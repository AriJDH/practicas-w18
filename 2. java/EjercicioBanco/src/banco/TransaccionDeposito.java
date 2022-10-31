package banco;

public interface TransaccionDeposito extends Transaccion {
    @Override
    void transaccionOK();

    @Override
    void transaccionNoOk();
}

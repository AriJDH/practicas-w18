package banco;

public interface TransaccionPago extends Transaccion{
    @Override
    void transaccionOK();

    @Override
    void transaccionNoOk();
}

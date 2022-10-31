package banco;

public interface TransaccionRetiro extends Transaccion{
    @Override
    void transaccionOK();

    @Override
    void transaccionNoOk();
}

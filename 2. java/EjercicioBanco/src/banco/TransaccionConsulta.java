package banco;

public interface TransaccionConsulta extends Transaccion{
    @Override
    void transaccionOK();

    @Override
    void transaccionNoOk();
}

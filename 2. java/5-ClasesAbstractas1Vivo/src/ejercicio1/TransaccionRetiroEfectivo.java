package ejercicio1;

public interface TransaccionRetiroEfectivo extends Transaccion{
    @Override
    void transaccionOk();

    @Override
    void transaccionNoOk();
}

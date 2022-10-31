package Ejercicio1;

public interface TransaccionPagoServicio extends Transaccion{
    @Override
    void transaccionOk();

    @Override
    void transaccionNoOk();
}

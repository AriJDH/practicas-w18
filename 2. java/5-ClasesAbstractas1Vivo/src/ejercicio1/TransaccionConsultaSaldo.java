package ejercicio1;

public interface TransaccionConsultaSaldo extends Transaccion {
    @Override
    void transaccionOk();

    @Override
    void transaccionNoOk();
}

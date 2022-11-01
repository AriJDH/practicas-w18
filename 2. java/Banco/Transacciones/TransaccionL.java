package Transacciones;

public interface TransaccionL {

    public abstract void transaccionOk(String tipoTransaccion);
    public abstract void transaccionNoOk(String tipoTransaccion);

}

package Interfaces;

public interface Transacciones {
    public abstract void transaccionOK(String tipoTransaccion);
    public abstract void transaccionNoOK(String tipoTransaccion);
}

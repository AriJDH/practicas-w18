package Banco;

public interface Transferencia extends Transaccion {
    void transferir(double monto, int origen, int destino);
}

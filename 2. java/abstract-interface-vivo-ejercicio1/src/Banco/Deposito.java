package Banco;

public interface Deposito extends Transaccion {

    void depositar(double monto, int destino);
}

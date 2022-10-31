package Banco;

public interface RetiroDeEfectivo extends Transaccion {

    void retirarEfectivo(int origen, double monto);
}

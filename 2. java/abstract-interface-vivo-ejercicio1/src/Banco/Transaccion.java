package Banco;

public interface Transaccion {
    void transaccionOk(String tipo);
    void transaccionNoOk(String tipo);
}

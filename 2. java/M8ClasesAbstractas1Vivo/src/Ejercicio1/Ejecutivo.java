package Ejercicio1;

public class Ejecutivo implements TransaccionDeposito, TransaccionTransferencia{
    @Override
    public void transaccionOk() {
        System.out.println("Transacción realizada con éxito");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("La transacción no se pudo realizar");
    }
}

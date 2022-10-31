package banco;

public class Ejecutivo implements TransaccionDeposito,TransaccionTransferencia{
    @Override
    public void transaccionOK() {
        System.out.println("Realizando Deposito");

    }

    @Override
    public void transaccionNoOk() {
        System.out.println("La transaccion no se pudo realizar");

    }
}

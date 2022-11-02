package ejercicio1;

public class Deposito implements Transaccion{

    public Deposito() {
    }
    @Override
    public void transaccionOk() {
        System.out.println("Realizándose depósito.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Error. La operación no pudo ser realizada.");
    }
}

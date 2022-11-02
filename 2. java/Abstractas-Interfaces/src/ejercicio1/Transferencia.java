package ejercicio1;

public class Transferencia implements Transaccion{

    public Transferencia() {
    }

    @Override
    public void transaccionOk() {
        System.out.println("Realizándose transferencia.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Error. La operación no pudo ser realizada.");
    }
}

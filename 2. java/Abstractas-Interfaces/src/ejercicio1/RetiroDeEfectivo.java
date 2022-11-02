package ejercicio1;

public class RetiroDeEfectivo implements Transaccion{

    public RetiroDeEfectivo() {
    }

    @Override
    public void transaccionOk() {
        System.out.println("Realizándose retiro de efectivo.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Error. La operación no pudo ser realizada.");
    }
}

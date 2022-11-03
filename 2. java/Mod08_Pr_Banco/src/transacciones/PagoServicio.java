package transacciones;

public class PagoServicio implements Transaccion{
    @Override
    public void transaccionOk() {
        System.out.println("Pago realizado con éxito!");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Pago Fallido! Intente de nuevo.");
    }
}

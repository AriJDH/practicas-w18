package transacciones;

public class RetiroEfectivo implements Transaccion{
    @Override
    public void transaccionOk() {
        System.out.println("Retiro realizado con éxito!");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Retiro Fallido! Intente de nuevo.");
    }
}

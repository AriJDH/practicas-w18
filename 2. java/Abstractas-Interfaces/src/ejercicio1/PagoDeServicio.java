package ejercicio1;

public class PagoDeServicio implements Transaccion{

    public PagoDeServicio() {
    }

    @Override
    public void transaccionOk() {
        System.out.println("Realizándose pago de servicio.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Error. La operación no pudo ser realizada.");
    }
}

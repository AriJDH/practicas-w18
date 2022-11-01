public class PagoDeServicios implements Transaccion{
    @Override
    public void transaccionOK(double monto) {
        System.out.println("Se realizo un pago de servicio "+ monto);
    }

    @Override
    public void transaccionNoOk(double monto) {
        System.out.println("No se realizo un pago de servicio "+ monto);
    }
}
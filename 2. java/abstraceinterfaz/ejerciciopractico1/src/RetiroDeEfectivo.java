public class RetiroDeEfectivo implements Transaccion{
    @Override
    public void transaccionOK(double monto) {
        System.out.println("Se realizo retiro de efectivo "+ monto);
    }

    @Override
    public void transaccionNoOk(double monto) {
        System.out.println("No se realizo retiro de efectivo "+ monto);
    }
}

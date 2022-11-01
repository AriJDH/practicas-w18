public class Transferencia implements Transaccion{
    @Override
    public void transaccionOK(double monto) {
        System.out.println("Se realizo el transferencia por la cantidad "+monto);
    }

    @Override
    public void transaccionNoOk(double monto) {
        System.out.println("No se realizo el transferencia por la cantidad "+monto);
    }
}
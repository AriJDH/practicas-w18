public class ConsultaDeSaldo implements Transaccion{
    @Override
    public void transaccionOK(double monto) {
        System.out.println("Se realizo una consulta de saldo " +monto);
    }

    @Override
    public void transaccionNoOk(double monto) {
        System.out.println("No se realizo una consulta de saldo " +monto);
    }
}

package clase3_a_ClasesAbsEInterfaces.Ejercicio1;

public class Ejecutivo implements Depositable, Transferible {

    @Override
    public void transaccionOk(String tipoTransaccion) {
        System.out.println(tipoTransaccion + " realizado con éxito!");
    }

    @Override
    public void transaccionNoOk(String tipoTransaccion) {
        System.out.println(tipoTransaccion + " no se pudo realizar!");
    }

    @Override
    public void depositar() {
        transaccionOk("Deposito");
    }

    @Override
    public void transferir() {
        transaccionOk("Transferencia");
    }
}

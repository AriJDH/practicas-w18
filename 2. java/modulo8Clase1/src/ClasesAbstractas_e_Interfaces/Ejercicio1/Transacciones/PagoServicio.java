package ClasesAbstractas_e_Interfaces.Ejercicio1.Transacciones;

public class PagoServicio implements ITransaccion {

    @Override
    public void transaccionOk() {
        System.out.println("Su pago fue realizado con éxito \n");
    }

    @Override
    public void transaccionNotOk() {
        System.out.println("Su pago fue rechazado, le sugerimos revisar el saldo en su cuenta \n");
    }
}

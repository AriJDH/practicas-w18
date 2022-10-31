package ClasesAbstractas_e_Interfaces.Transacciones;

import ClasesAbstractas_e_Interfaces.Transacciones.Transaccion;

public class PagoServicio implements Transaccion {

    @Override
    public void transaccionOk() {
        System.out.println("Su pago fue realizado con éxito \n");
    }

    @Override
    public void transaccionNotOk() {
        System.out.println("Su pago fue rechazado, le sugerimos revisar el saldo en su cuenta \n");
    }
}

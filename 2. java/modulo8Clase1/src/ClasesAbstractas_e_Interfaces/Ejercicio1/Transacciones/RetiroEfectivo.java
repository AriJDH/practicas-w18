package ClasesAbstractas_e_Interfaces.Transacciones;

import ClasesAbstractas_e_Interfaces.Transacciones.Transaccion;

public class RetiroEfectivo implements Transaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Su retiro fue realizado con éxito \n");
    }

    @Override
    public void transaccionNotOk() {
        System.out.println("Usted no cuenta con los fondos suficientes \n");
    }
}

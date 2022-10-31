package ClasesAbstractas_e_Interfaces.Clientes;

import ClasesAbstractas_e_Interfaces.Transacciones.ConsultaSaldo;
import ClasesAbstractas_e_Interfaces.Transacciones.RetiroEfectivo;
import ClasesAbstractas_e_Interfaces.Transacciones.Transaccion;

import java.util.Random;

public class Cobrador extends Cliente {
    public void consultaSaldo() {
        Transaccion t = new ConsultaSaldo();
        Random rd = new Random();
        if (rd.nextBoolean()) {
            t.transaccionOk();
        } else {
            t.transaccionNotOk();
        }
    }

    public void retiroEfectivo() {
        Transaccion t = new RetiroEfectivo();
        Random rd = new Random();
        if (rd.nextBoolean()) {
            t.transaccionOk();
        } else {
            t.transaccionNotOk();
        }
    }
}

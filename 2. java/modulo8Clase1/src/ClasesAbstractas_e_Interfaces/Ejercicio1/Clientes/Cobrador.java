package ClasesAbstractas_e_Interfaces.Ejercicio1.Clientes;

import ClasesAbstractas_e_Interfaces.Ejercicio1.Transacciones.ConsultaSaldo;
import ClasesAbstractas_e_Interfaces.Ejercicio1.Transacciones.RetiroEfectivo;
import ClasesAbstractas_e_Interfaces.Ejercicio1.Transacciones.ITransaccion;

import java.util.Random;

public class Cobrador extends Cliente {
    public void consultaSaldo() {
        ITransaccion t = new ConsultaSaldo();
        Random rd = new Random();
        if (rd.nextBoolean()) {
            t.transaccionOk();
        } else {
            t.transaccionNotOk();
        }
    }

    public void retiroEfectivo() {
        ITransaccion t = new RetiroEfectivo();
        Random rd = new Random();
        if (rd.nextBoolean()) {
            t.transaccionOk();
        } else {
            t.transaccionNotOk();
        }
    }
}

package ClasesAbstractas_e_Interfaces.Ejercicio1.Clientes;

import ClasesAbstractas_e_Interfaces.Ejercicio1.Transacciones.Deposito;
import ClasesAbstractas_e_Interfaces.Ejercicio1.Transacciones.ITransaccion;
import ClasesAbstractas_e_Interfaces.Ejercicio1.Transacciones.Transferencia;

import java.util.Random;

public class Ejecutivo extends Cliente {
    public void depositoEfectivo(){
        ITransaccion t = new Deposito();
        Random rd = new Random();
        if (rd.nextBoolean()){
            t.transaccionOk();
        } else {
            t.transaccionNotOk();
        }
    }

    public void transferenciaEfectivo(){
        ITransaccion t = new Transferencia();
        Random rd = new Random();
        if (rd.nextBoolean()){
            t.transaccionOk();
        } else {
            t.transaccionNotOk();
        }
    }
}

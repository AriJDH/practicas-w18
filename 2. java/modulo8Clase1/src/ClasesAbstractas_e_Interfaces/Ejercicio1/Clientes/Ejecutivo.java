package ClasesAbstractas_e_Interfaces.Clientes;

import ClasesAbstractas_e_Interfaces.Transacciones.Deposito;
import ClasesAbstractas_e_Interfaces.Transacciones.RetiroEfectivo;
import ClasesAbstractas_e_Interfaces.Transacciones.Transaccion;
import ClasesAbstractas_e_Interfaces.Transacciones.Transferencia;

import java.util.Random;

public class Ejecutivo extends Cliente {
    public void depositoEfectivo(){
        Transaccion t = new Deposito();
        Random rd = new Random();
        if (rd.nextBoolean()){
            t.transaccionOk();
        } else {
            t.transaccionNotOk();
        }
    }

    public void transferenciaEfectivo(){
        Transaccion t = new Transferencia();
        Random rd = new Random();
        if (rd.nextBoolean()){
            t.transaccionOk();
        } else {
            t.transaccionNotOk();
        }
    }
}

package Ejercicio1.Clientes;

import Ejercicio1.Transacciones.Deposito;
import Ejercicio1.Transacciones.Transaccion;
import Ejercicio1.Transacciones.Transferencia;

public class Ejecutivos extends Cliente {

    @Override
    void implTransaccion(Transaccion t) {
        t.transaccionOk();
    }
}

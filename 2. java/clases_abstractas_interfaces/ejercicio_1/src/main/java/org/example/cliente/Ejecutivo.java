package org.example.cliente;

import org.example.transaccion.Depositable;
import org.example.transaccion.Transferible;

public class Ejecutivo implements Depositable, Transferible {

    @Override
    public void depositar(double monto) {
        System.out.println("El monto depositado es de : $" + monto);
        transaccionOk("depositar dinero");
    }

    @Override
    public void tranferir(double monto) {
        System.out.println("El monto transferido es de: $" + monto);
        transaccionOk("transferir dinero");
    }
}

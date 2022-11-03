package org.example.cliente;

import org.example.transaccion.Consultable;
import org.example.transaccion.Retirable;

public class Cobrador implements Retirable, Consultable {

    @Override
    public void consultarSaldo() {
        System.out.println("Su saldo es de : $...");
        transaccionOk("consultar saldo");
    }

    @Override
    public void retirar(double monto) {
        System.out.println("El monto retirado es de: $" + monto);
        transaccionOk("retirar dinero");
    }
}
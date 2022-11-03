package org.example.cliente;

import org.example.transaccion.Consultable;
import org.example.transaccion.Pagable;
import org.example.transaccion.Retirable;

public class Basic implements Consultable, Pagable, Retirable {

    @Override
    public void consultarSaldo() {
        System.out.println("Su saldo es de: $...");
        transaccionOk("consultar saldo");
    }

    @Override
    public void pagarServicio(double monto) {
        System.out.println("El monto a pagar es de : $" + monto);
        transaccionOk("pagar servico");

    }

    @Override
    public void retirar(double monto) {
        System.out.println("Su saldo a retirar es de: $" + monto);
        transaccionOk("retirar dinero");
    }
}

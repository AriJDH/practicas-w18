package Ejercicio1.model;

import Ejercicio1.Interface.Consultable;
import Ejercicio1.Interface.Pagable;
import Ejercicio1.Interface.Retirable;

public class Basic implements Consultable, Pagable, Retirable {




    @Override
    public void consultarSaldo() {
        System.out.println("Su saldo es de: $...");
        transaccionOk("consultar saldo");
    }

    @Override
    public void pagarServicio(double monto) {
        System.out.println("El monto a pagar es de : $"+monto);
        transaccionOk("pagar servico");

    }

    @Override
    public void retirar(double monto) {
        System.out.println("Su saldo a retirar es de: $"+monto);
        transaccionOk("Retirar dinero");
    }

}

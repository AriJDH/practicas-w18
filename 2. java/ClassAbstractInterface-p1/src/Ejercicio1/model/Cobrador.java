package Ejercicio1.model;

import Ejercicio1.Interface.Consultable;
import Ejercicio1.Interface.Retirable;

public class Cobrador implements Retirable, Consultable {
    @Override
    public void consultarSaldo() {
        System.out.println("Su saldo es de : $...");
        transaccionOk("Consultar Saldo");
    }

    @Override
    public void retirar(double monto) {

        System.out.println("El monto retirado es de: $"+monto);
        transaccionOk("retirar dinero");
    }
}

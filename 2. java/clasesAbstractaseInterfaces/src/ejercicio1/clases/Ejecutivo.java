package ejercicio1.clases;

import ejercicio1.interfaces.Depositable;
import ejercicio1.interfaces.Transferible;

public class Ejecutivo implements Depositable, Transferible {
    private double saldo;

    public Ejecutivo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public void transferirDinero(double monto) {
        if(monto <= saldo && monto>0) {
            saldo = saldo - monto;
            transaccionOK("Transferencia de dinero");
            System.out.println("Se transfirió un monto de $" + monto);
        } else if (monto > saldo) {
            transaccionNoOk("Transferencia de dinero");
            System.out.println("Fondos insuficientes");
        } else {
            transaccionNoOk("Transferencia de dinero");
            System.out.println("Por favor, ingrese un monto superior a cero");
        }
    }

    @Override
    public void depositarDinero(double monto) {
        if (monto >0) {
            saldo = saldo+monto;
            transaccionOK("Depósito de dinero");
            System.out.println("Se depositó un monto de $" + monto);
        } else {
            transaccionNoOk("Depósito de dinero");
            System.out.println("Por favor, ingrese un monto superior a 0");
        }
    }
}

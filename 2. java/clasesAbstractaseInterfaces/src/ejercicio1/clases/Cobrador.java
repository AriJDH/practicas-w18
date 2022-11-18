package ejercicio1.clases;

import ejercicio1.interfaces.Consultable;
import ejercicio1.interfaces.Retirable;

public class Cobrador implements Retirable, Consultable {
    private double saldo;

    public Cobrador(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public void retirarDinero(double monto) {
        if (monto <= saldo && monto>0) {
            saldo = saldo - monto;
            transaccionOK("Retiro de dinero");
            System.out.println("Se realizó un retiro de $" + monto);
        } else if (monto > saldo) {
            transaccionNoOk("Retiro de dinero");
            System.out.println("Fondos insuficientes");
        } else{
            transaccionNoOk("Retiro de dinero");
            System.out.println("Por favor, ingrese un monto superior a 0");
        }
    }
    @Override
    public void consultarSaldo() {
        transaccionOK("Consulta de saldo");
        System.out.println("El saldo en su cuenta es $"+saldo);
    }
}

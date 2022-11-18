package ejercicio1.clases;

import ejercicio1.interfaces.Consultable;
import ejercicio1.interfaces.Pagable;
import ejercicio1.interfaces.Retirable;

public class Basic implements Consultable, Pagable, Retirable {
    private double saldo;

    public Basic(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public void consultarSaldo() {
        transaccionOK("Consulta de saldo");
        System.out.println("El saldo en su cuenta es $"+saldo);
    }

    @Override
    public void pagarServicio(double monto) {
        if(monto <= saldo && monto>0) {
            saldo = saldo - monto;
            transaccionOK("Pago de servicio");
            System.out.println("Se realizó el pago por un monto de $" + monto);
        } else if (monto>saldo){
            transaccionNoOk("Pago de servicio");
            System.out.println("Fondos insuficientes");
        } else {
            transaccionNoOk("Pago de servicio");
            System.out.println("Por favor, ingrese un monto superior a cero");
        }
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
    public String toString() {
        return "Basic{" +
                "saldo=" + saldo +
                '}';
    }
}

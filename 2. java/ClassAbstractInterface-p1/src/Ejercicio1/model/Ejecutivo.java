package Ejercicio1.model;

import Ejercicio1.Interface.Depositable;
import Ejercicio1.Interface.Transferible;

public class Ejecutivo implements Depositable, Transferible {
    @Override
    public void depositar(double monto) {

        System.out.println("El monto depositado es de : $"+monto);
        transaccionOk("depositar dinero");
    }

    @Override
    public void tranferir(double monto) {

        System.out.println("El monto transferido es de: $"+monto);
        transaccionOk("Transferir dinero");
    }
}

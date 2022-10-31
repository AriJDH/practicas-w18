package Ejercicio1;

import Ejercicio1.model.Basic;

public class Test {
    public static void main(String[] args) {
        Basic basic=new Basic();

        basic.transaccionOk("Deposito");
        basic.consultarSaldo();
        basic.retirar(2000.);
        basic.pagarServicio(1000.);
    }
}

package org.example;

import org.example.cliente.Basic;

public class Test {
    public static void main(String[] args) {
        Basic basic=new Basic();

        basic.transaccionOk("Deposito");
        basic.consultarSaldo();
        basic.retirar(10000f);
        basic.pagarServicio(500f);
    }
}
package com.company.Clases;

public class Main {

    public static void main(String[] args) {
        System.out.println("------BANCO------");
        Ejecutivo ej = new Ejecutivo();
        Basic ba = new Basic();

        ej.hacerDeposito();
        ej.hacerTransferencia();
        ej.transaccionNoOk("Deposito");
        ej.transaccionOk("Transferencia");

        ba.transaccionNoOk("Deposito");
        ba.transaccionOk("Transferencia");
    }
}

package com.meli.lgutierrez.clase3.ejercicioPractico1;

public class Deposito implements Transaccion{

    @Override
    public void transaccionOk() {
        System.out.println("Realizando un depósito");
    }

    @Override
    public void transaccionNoOK() {
        System.out.println("No se pudo realizar el depósito");
    }
}

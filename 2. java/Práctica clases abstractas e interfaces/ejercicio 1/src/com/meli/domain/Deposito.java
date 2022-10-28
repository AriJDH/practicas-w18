package com.meli.domain;

public class Deposito implements Transaccion{
    @Override
    public void transaccionOk() {
        System.out.println("Depósito confirmado.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Depósito cancelado.");
    }
}

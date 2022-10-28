package com.meli.domain;

public class Transferencia implements Transaccion{
    @Override
    public void transaccionOk() {
        System.out.println("Transferencia confirmada.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Transferencia cancelada");
    }
}

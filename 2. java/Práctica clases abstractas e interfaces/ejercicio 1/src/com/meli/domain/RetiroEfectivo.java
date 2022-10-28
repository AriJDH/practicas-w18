package com.meli.domain;

public class RetiroEfectivo implements Transaccion{
    @Override
    public void transaccionOk() {
        System.out.println("Retiro confirmado.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Retiro cancelado.");
    }
}

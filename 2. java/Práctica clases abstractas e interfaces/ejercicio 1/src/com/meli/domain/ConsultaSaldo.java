package com.meli.domain;

public class ConsultaSaldo implements Transaccion{

    @Override
    public void transaccionOk() {
        System.out.println("Consulta de saldo confirmada.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Consulta de saldo cancelada.");
    }
}

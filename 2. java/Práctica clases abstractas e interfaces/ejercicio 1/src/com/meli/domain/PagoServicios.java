package com.meli.domain;

public class PagoServicios implements Transaccion{

    @Override
    public void transaccionOk() {
        System.out.println("Pago de servicios confirmado.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Pago de servicios cancelado.");
    }
}

package com.meli.lgutierrez.clase3.ejercicioPractico1;

public class PagoServicio implements Transaccion{
    @Override
    public void transaccionOk() {
        System.out.println("Realizando un pago de servicio");
    }

    @Override
    public void transaccionNoOK() {
        System.out.println("No se pudo realizar un pago de servicio");
    }
}

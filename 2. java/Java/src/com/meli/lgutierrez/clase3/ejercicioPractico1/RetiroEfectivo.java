package com.meli.lgutierrez.clase3.ejercicioPractico1;

public class RetiroEfectivo implements Transaccion{
    @Override
    public void transaccionOk() {
        System.out.println("Realizando un retiro en efectivo");
    }

    @Override
    public void transaccionNoOK() {
        System.out.println("No se pudo realizar el retiro en efectivo");
    }
}

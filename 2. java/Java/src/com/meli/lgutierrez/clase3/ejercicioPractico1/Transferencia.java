package com.meli.lgutierrez.clase3.ejercicioPractico1;

public class Transferencia implements Transaccion{


    @Override
    public void transaccionOk() {
        System.out.println("Realizando transferencia");
    }

    @Override
    public void transaccionNoOK() {
        System.out.println("No se pudo realizar la transferencia");
    }
}

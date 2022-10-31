package com.meli.lgutierrez.clase3.ejercicioPractico1;

public class ConsultaSaldo implements Transaccion{
    @Override
    public void transaccionOk() {
        System.out.println("Consultando saldo");
    }

    @Override
    public void transaccionNoOK() {
        System.out.println("No se pudo realizar la consulta del saldo");
    }
}

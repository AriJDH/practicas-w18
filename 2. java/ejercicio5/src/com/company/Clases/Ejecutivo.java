package com.company.Clases;

import com.company.Interfaces.Deposito;
import com.company.Interfaces.Transferencia;

public class Ejecutivo implements Deposito, Transferencia {
    @Override
    public void transaccionOk(String tipoTransacc) {
        System.out.println("Transacción ok ... ");
    }

    @Override
    public void transaccionNoOk(String tipoTransacc) {

    }

    @Override
    public void hacerTransferencia() {

    }

    @Override
    public void denegarTransferencia() {

    }

    @Override
    public void hacerDeposito() {

    }
    //ver que iría dentro
}

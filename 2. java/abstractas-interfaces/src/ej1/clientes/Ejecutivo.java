package ej1.clientes;

import ej1.transacciones.Deposito;
import ej1.transacciones.Transferencia;

public class Ejecutivo extends Cliente implements Deposito, Transferencia {


    @Override
    public void realizarDeposito() {
        System.out.println("Realizando depósito");
        if(super.getRd().nextBoolean()) {
            transaccionOk();
        } else {
            transaccionNoOk();
        }
    }

    @Override
    public void transaccionOk() {
        System.out.println("Transacción ok");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Transacción no ok");
    }

    @Override
    public void realizarTransferencia() {
        System.out.println("Realizando transferencia");
        if(super.getRd().nextBoolean()) {
            transaccionOk();
        } else {
            transaccionNoOk();
        }
    }
}

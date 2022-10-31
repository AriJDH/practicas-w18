package com.meli.lgutierrez.clase3.ejercicioPractico1;

public class Ejecutivo {
    private Deposito deposito;
    private Transferencia transferencia;

    public Ejecutivo(Deposito deposito) {
        this.deposito = deposito;
    }

    public Ejecutivo(Transferencia transferencia) {
        this.transferencia = transferencia;
    }

    public Ejecutivo(Deposito deposito, Transferencia transferencia) {
        this.deposito = deposito;
        this.transferencia = transferencia;
    }

    public Deposito getDeposito() {
        return deposito;
    }

    public void setDeposito(Deposito deposito) {
        this.deposito = deposito;
    }

    public Transferencia getTransferencia() {
        return transferencia;
    }

    public void setTransferencia(Transferencia transferencia) {
        this.transferencia = transferencia;
    }
}

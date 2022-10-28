package meli.bootcamp.clases;

import meli.bootcamp.interfaces.Depositable;
import meli.bootcamp.interfaces.Transferenciable;

public class Ejecutivo implements Depositable, Transferenciable {
    @Override
    public void depositarDinero() {
        System.out.println("Dinero depositado");
    }

    @Override
    public void realizarTransferencia() {
        System.out.println("Transferencia realizada");
    }

    @Override
    public void transaccionOk() {
        System.out.println("Transaccion ok");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Transaccion no ok");
    }
}

package model;

import interfaces.Deposito;
import interfaces.Transferencia;

public class Ejecutivo implements Deposito, Transferencia {

    @Override
    public void transferir() {
        System.out.println("Está por realizar una transferencia");
    }

    @Override
    public void depositar() {
        System.out.println("Está por realizar un deposito");
    }

    @Override
    public void transaccionOk(String transaccion) {
        System.out.println(transaccion + " realizad@ con éxito");
    }

    @Override
    public void transaccionNoOk(String transaccion) {
        System.out.println(transaccion + " fallad@");
    }
}

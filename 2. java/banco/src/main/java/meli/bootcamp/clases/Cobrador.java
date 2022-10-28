package meli.bootcamp.clases;

import meli.bootcamp.interfaces.Consultable;
import meli.bootcamp.interfaces.Retirable;

public class Cobrador implements Retirable, Consultable {
    @Override
    public void consultarSaldo() {
        System.out.println("Saldo actual");
    }

    @Override
    public void transaccionOk() {
        System.out.println("Transaccion ok");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Transaccion no ok");

    }

    @Override
    public void retirarDinero() {
        System.out.println("Saldo retirado");
    }
}

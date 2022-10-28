package meli.bootcamp.clases;

import meli.bootcamp.interfaces.Consultable;
import meli.bootcamp.interfaces.Pagable;
import meli.bootcamp.interfaces.Retirable;

public class Basic implements Consultable, Pagable, Retirable {
    @Override
    public void consultarSaldo() {
        System.out.println("Saldo actual");
    }

    @Override
    public void pagoServicios() {
        System.out.println("Pago realizado");
    }

    @Override
    public void retirarDinero() {
        System.out.println("Dinero retirado");
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

package Clientes;

import Transacciones.ConsultaSaldo;
import Transacciones.PagoServicio;
import Transacciones.RetiroEfectivo;

public class Basic implements ConsultaSaldo, PagoServicio, RetiroEfectivo {
    @Override
    public void consultarSaldo() {
        System.out.println("Consultando saldo...");
    }

    @Override
    public void pagarServicio() {
        System.out.println("Pagando servicio...");
    }

    @Override
    public void retirarEfectivo() {
        System.out.println("Retirando efectivo...");
    }

    @Override
    public void transaccionOk() {
        System.out.println("Transacción realizada correctamente.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("No se pudo realizar la transacción.");
    }
}

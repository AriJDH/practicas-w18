package Clientes;

import Transacciones.ConsultaSaldo;
import Transacciones.RetiroEfectivo;

public class Cobradores implements RetiroEfectivo, ConsultaSaldo {
    @Override
    public void consultarSaldo() {
        System.out.println("Consultando saldo...");
    }

    @Override
    public void retirarEfectivo() {
        System.out.println("Retirando efectivo...");
    }

    @Override
    public void transaccionOk() {
        System.out.println("La transacción se realizó correctamente.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("No se pudo realizar la transacción.");
    }
}

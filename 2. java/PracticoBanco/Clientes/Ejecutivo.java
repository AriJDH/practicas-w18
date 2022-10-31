package Clientes;

import Transacciones.Deposito;
import Transacciones.Transaccion;
import Transacciones.Transferencia;

public class Ejecutivo implements Deposito, Transferencia {


    @Override
    public void realizarDeposito() {
        System.out.println("Realizando deposito...");
    }

    @Override
    public void transaccionOk() {
        System.out.println("Transacción realizada correctamente.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("No se pudo realizar la transacción.");
    }

    @Override
    public void realizarTransferencia() {
        System.out.println("Realizando transferencia...");
    }
}

package Banco.Clases;

import Banco.Interfaces.Deposito;
import Banco.Interfaces.Transferencia;

public class Ejecutivos implements Deposito, Transferencia {
    public Ejecutivos() {
    }

    @Override
    public void hacerDeposito(double valorDepositar) {
        System.out.println("Deposito de "+ valorDepositar + " realizado con éxito");
        this.transaccionOK("Hacer deposito");
    }

    @Override
    public void transaccionOK(String tipoTransaccion) {
        System.out.println("Transacción "+tipoTransaccion +" OK");
    }

    @Override
    public void transaccionNoOK(String tipoTransaccion) {
        System.out.println("Transacción "+ tipoTransaccion + " no es posible");
    }

    @Override
    public void realizarTransferencia(double valorTransferir) {
        System.out.println("Transferencia de "+ valorTransferir + " realizado con éxito");
    }
}

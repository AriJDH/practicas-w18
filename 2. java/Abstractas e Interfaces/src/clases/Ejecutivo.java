package clases;

import interfaces.Deposito;
import interfaces.Transferencia;

public class Ejecutivo implements Deposito, Transferencia {
    @Override
    public void transaccionOk() {
        System.out.println("Transaccion realizada");
    }

    @Override
    public void transaccionNoOk() {

    }


    @Override
    public void realizarTransferencia() {

    }


}

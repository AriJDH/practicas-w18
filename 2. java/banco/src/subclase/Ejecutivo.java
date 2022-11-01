package subclase;

import Interfaces.Deposito;
import Interfaces.Transferencia;
import superclase.Cliente;

public class Ejecutivo extends Cliente implements Deposito, Transferencia {

    @Override
    public void transaccionOK() {
        System.out.println("La transacción se ha realizado correctamente");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("La transacción NO se ha realizado correctamente");
    }

    @Override
    public void realizarTransferencia() {
        System.out.println("Se está realizando la transferencia");
    }

    @Override
    public void realizarDeposito() {
        System.out.println("Se está realizando el depósito");
    }

}

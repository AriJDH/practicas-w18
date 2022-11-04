package ejercicio1.model;

import ejercicio1.interfaces.Deposito;
import ejercicio1.interfaces.Transferencia;

public class Ejecutivo extends Cliente implements Deposito, Transferencia {

    @Override
    public void hacerDeposito(int montoDeposito) {

        System.out.println("Realizando deposito por: $" + montoDeposito);
        randomizador();
        System.out.println();

    }

    @Override
    public void hacerTransferencia(int montoTransferencia, String idCliente) {

        System.out.println("Realizando Transferencia de: $" + montoTransferencia + " al Cliente: " + idCliente);
        randomizador();
        System.out.println();
    }

}

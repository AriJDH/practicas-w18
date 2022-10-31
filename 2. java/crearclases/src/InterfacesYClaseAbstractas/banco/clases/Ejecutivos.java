package InterfacesYClaseAbstractas.banco.clases;

import InterfacesYClaseAbstractas.banco.interfaces.Deposito;
import InterfacesYClaseAbstractas.banco.interfaces.Transferencia;

public class Ejecutivos implements Deposito, Transferencia {
    @Override
    public void hacerDeposito(double monto) {
        System.out.println(" deposito en efectivo");
    }

    @Override
    public void transaccionesOk(String transaccion) {
        System.out.println("transacción aprobada");
    }

    @Override
    public void transaccionesNoOk(String transaccion) {
        System.out.println("transacción no aprobada");
    }

    @Override
    public void hacerTransferencia(String destinatario, double monto) {
        System.out.println("hacer transferencia a " + destinatario + "por el monto de " + monto);
    }
}

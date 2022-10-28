package practica_abstracta_interfaces_vivo.ejercicio1.clases;

import practica_abstracta_interfaces_vivo.ejercicio1.interfaces.IDeposito;
import practica_abstracta_interfaces_vivo.ejercicio1.interfaces.ITransferencia;

public class Ejecutivo implements IDeposito, ITransferencia {

    @Override
    public void transaccionOk() {
        System.out.println("Transferencia ok ejecutivo");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Transferencia noOk ejecutivo");
    }

    @Override
    public void crearDeposito() {
        System.out.println("crear deposito");
    }

    @Override
    public void crearTransferencia() {
        System.out.println("crear transferencia");
    }
}

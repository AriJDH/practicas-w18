package classes;

import interfaces.Deposito;
import interfaces.Transferencia;

public class Ejecutivo implements Deposito, Transferencia {
    @Override
    public void realizarDeposito(double importe) {
        boolean deposito = true;

        if(deposito){
            transactionOk("depósito por un importe de $" + importe + ", ");
        }else{
            transactionNoOk("depósito por un importe de $" + importe + ", ");
        }
    }

    @Override
    public void realizarTransferencia(double importe) {

        boolean transferencia = false;

        if(transferencia){
            transactionOk("transferencia por un importe de $" + importe + ", ");
        }else{
            transactionNoOk("transferencia por un importe de $" + importe + ", ");
        }
    }

    @Override
    public void transactionOk(String tipo) {
        System.out.println("La transacción " + tipo + " se ha realizado con éxito.");
    }

    @Override
    public void transactionNoOk(String tipo) {
        System.out.println("La transacción " + tipo + " no se ha podido realizar con éxito. Intente nuevamente por favor.");
    }
}

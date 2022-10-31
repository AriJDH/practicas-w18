package Clientes;

import Banco.Deposito;
import Banco.Transferencia;

public class Ejecutivo implements Deposito, Transferencia {
    int ID;

    public Ejecutivo(int ID) {
        this.ID = ID;
    }

    @Override
    public void depositar(double monto, int destino) {
        System.out.println(
                "Realizando deposito de " + monto +
                " en la cuenta " + destino
        );
        transaccionOk("deposito");
    }

    @Override
    public void transferir(double monto, int origen, int destino) {
        System.out.println(
                "Realizando transferencia de " + monto +
                " desde la cuenta " + origen +
                " hacia la cuenta " + destino
        );
        transaccionOk("transferencia");
    }

    @Override
    public void transaccionOk(String tipo) {
        System.out.println("Transaccion de tipo " + tipo + " exitosa :)");
    }

    @Override
    public void transaccionNoOk(String tipo) {
        System.out.println("Transaccion de tipo " + tipo + " fallida :)");
    }
}







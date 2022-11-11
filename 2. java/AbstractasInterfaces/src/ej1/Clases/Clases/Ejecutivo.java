package ej1.Clases.Clases;

import ej1.Clases.Interfaces.Deposito;
import ej1.Clases.Interfaces.Transacciones;
import ej1.Clases.Interfaces.Transferencia;

public class Ejecutivo implements Transacciones, Deposito, Transferencia {

    @Override
    public String transaccionOk(String tipoTransf) {
        return "Transaccion " +  tipoTransf + " aceptada";
    }

    @Override
    public String transaccionNoOk(String tipoTransf) {
        return "La transaccion " + tipoTransf + " tuvo un problema";
    }

    @Override
    public String depositarDinero(double amount) {
        return amount + " fue depositado";
    }

    @Override
    public String transferir(double amount, String target) {
        return amount + " fueron transferidos a la cuenta " + target;
    }
}

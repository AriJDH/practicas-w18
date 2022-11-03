package Clases;

import Interfaces.Deposito;
import Interfaces.Transferencia;

public class Ejecutivo implements Deposito, Transferencia {

    @Override
    public String hacerDeposito(){
        return "Haciendo deposito...";
    }

    @Override
    public String hacerTransferencia(){
        return "Transfiriendo dinero...";
    }

    @Override
    public String transaccionOk() {
        return "Su deposito/transferencia fue exitoso";
    }

    @Override
    public String transaccionNoOk() {
        return "Su deposito/transferencia fue rechazado";
    }
}


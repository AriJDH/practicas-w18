package Clientes;

import Transacciones.DepositoL;
import Transacciones.TransferenciaL;

public class Ejecutivo implements DepositoL, TransferenciaL {

    @Override
    public void hacerDeposito(){
        System.out.println("Realizando deposito...");
    }

    @Override
    public void hacerTransferencia(){
        System.out.println("Realizando transferencia..");
    }

    @Override
    public void transaccionOk(String tipoTransaccion){
        System.out.println(tipoTransaccion + "Finalizada correctamente");
    }
    @Override
    public void transaccionNoOk(String tipoTransaccion){
        System.out.println(tipoTransaccion + "No se pudo realizar correctamente");
    }


}

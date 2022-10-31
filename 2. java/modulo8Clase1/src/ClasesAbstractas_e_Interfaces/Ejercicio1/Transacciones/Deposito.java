package ClasesAbstractas_e_Interfaces.Transacciones;

import ClasesAbstractas_e_Interfaces.Transacciones.Transaccion;

public class Deposito implements Transaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Depósito exitoso \n");
    }

    @Override
    public void transaccionNotOk() {
        System.out.println("No se pudo realizar el depósito, favor comunicarse al 911 \n");
    }



}

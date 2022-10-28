package practica_abstracta_interfaces_vivo.ejercicio1.clases;

import practica_abstracta_interfaces_vivo.ejercicio1.interfaces.IConsultaSaldo;
import practica_abstracta_interfaces_vivo.ejercicio1.interfaces.IRetiroEfectivo;

public class Cobrador implements IRetiroEfectivo, IConsultaSaldo {

    @Override
    public void consultarSaldo() {
        System.out.println("consultar saldo cobrador");
    }

    @Override
    public void retirarEfectivo() {
        System.out.println("Retirar efectivo");

    }

    @Override
    public void transaccionOk() {
        System.out.println("Transaccion OK cobrador");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Transaccion noOK cobrador");
    }
}

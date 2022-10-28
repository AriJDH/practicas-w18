package practica_abstracta_interfaces_vivo.ejercicio1.clases;

import practica_abstracta_interfaces_vivo.ejercicio1.interfaces.IConsultaSaldo;
import practica_abstracta_interfaces_vivo.ejercicio1.interfaces.IPagoServicio;
import practica_abstracta_interfaces_vivo.ejercicio1.interfaces.IRetiroEfectivo;

public class Basic implements IConsultaSaldo, IPagoServicio, IRetiroEfectivo {

    @Override
    public void consultarSaldo() {
        System.out.println("consultar saldo");
    }

    @Override
    public void transaccionOk() {
        System.out.println("transaccion ok Basic");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("transferencia noOk basic");
    }

    @Override
    public void pagarServicio() {
        System.out.println("pagar servicio");
    }

    @Override
    public void retirarEfectivo() {
        System.out.println("retirar efectivo");
    }
}

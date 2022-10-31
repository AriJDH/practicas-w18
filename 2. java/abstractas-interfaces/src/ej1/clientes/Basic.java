package ej1.clientes;

import ej1.transacciones.ConsultaSaldo;
import ej1.transacciones.Efectivo;
import ej1.transacciones.PagoServicios;

public class Basic extends Cliente implements ConsultaSaldo, PagoServicios, Efectivo {

    @Override
    public void realizarConsultaSaldo() {
        System.out.println("Realizando consulta de salgo");
        if (super.getRd().nextBoolean()) {
            transaccionOk();
        } else {
            transaccionNoOk();
        }
    }

    @Override
    public void realizarRetiroEnEfectivo() {
        System.out.println("Realizando retiro de efectivo");
        if (super.getRd().nextBoolean()) {
            transaccionOk();
        } else {
            transaccionNoOk();
        }
    }

    @Override
    public void realizarPagoServicios() {
        System.out.println("Realizando pago de servicios");
        if (super.getRd().nextBoolean()) {
            transaccionOk();
        } else {
            transaccionNoOk();
        }
    }

    @Override
    public void transaccionOk() {
        System.out.println("Transacción ok");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Transacción no ok");
    }
}

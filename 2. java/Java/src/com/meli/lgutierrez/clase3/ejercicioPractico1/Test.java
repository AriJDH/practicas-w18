package com.meli.lgutierrez.clase3.ejercicioPractico1;

public class Test {
    public static void main(String[] args) {
        Ejecutivo ejecutivo1 = new Ejecutivo(new Deposito());
        Ejecutivo ejecutivo2 = new Ejecutivo(new Transferencia());

        Basic basic1 = new Basic(new ConsultaSaldo());
        Basic basic2 = new Basic(new PagoServicio());
        Basic basic3 = new Basic(new RetiroEfectivo());

        Cobradores cobrador1 = new Cobradores(new RetiroEfectivo());
        Cobradores cobrador2 = new Cobradores(new ConsultaSaldo());

        ejecutivo1.getDeposito().transaccionNoOK();
        ejecutivo2.getTransferencia().transaccionOk();

        basic1.getConsultaSaldo().transaccionOk();
        basic2.getPagoServicio().transaccionNoOK();
        basic3.getRetiroEfectivo().transaccionOk();

        cobrador1.getRetiroEfectivo().transaccionOk();
        cobrador2.getConsultaSaldo().transaccionNoOK();

    }
}

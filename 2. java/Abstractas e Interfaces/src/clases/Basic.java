package clases;

import interfaces.ConsultaSaldo;
import interfaces.PagoServicio;
import interfaces.RetiroEfectivo;

public class Basic implements ConsultaSaldo, PagoServicio, RetiroEfectivo {
    @Override
    public void transaccionOk() {

    }

    @Override
    public void transaccionNoOk() {

    }
}

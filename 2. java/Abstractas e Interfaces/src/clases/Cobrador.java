package clases;

import interfaces.ConsultaSaldo;
import interfaces.RetiroEfectivo;

public class Cobrador implements RetiroEfectivo, ConsultaSaldo {
    @Override
    public void transaccionOk() {
        System.out.println();
    }

    @Override
    public void transaccionNoOk() {

    }
}

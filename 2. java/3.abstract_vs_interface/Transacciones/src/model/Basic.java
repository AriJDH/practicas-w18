package model;

import interfaces.ConsultaDeSaldo;
import interfaces.PagoDeServicios;
import interfaces.RetiroEfectivo;

public class Basic implements ConsultaDeSaldo, PagoDeServicios, RetiroEfectivo {
    @Override
    public void consultarSaldo() {
        System.out.println("Consultando saldo....");
    }

    @Override
    public void pagarServicios() {
        System.out.println("Pagando servicios...");
    }

    @Override
    public void retiroDeEfectivo() {
        System.out.println("Retirando efectivo...");
    }
    @Override
    public void transaccionOk(String transaccion) {
        System.out.println("Transaccion "+transaccion+" realizada con éxito");
    }

    @Override
    public void transaccionNoOk(String transaccion) {
        System.out.println("Transaccion "+transaccion+" FALLO");

    }


}

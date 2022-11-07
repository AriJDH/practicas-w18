package model;

import interfaces.ConsultaDeSaldo;
import interfaces.RetiroEfectivo;

public class Cobradores implements ConsultaDeSaldo, RetiroEfectivo {
    @Override
    public void consultarSaldo() {
        System.out.println("Consultando saldo...");
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

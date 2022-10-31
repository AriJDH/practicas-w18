package Clientes;

import Banco.ConsultaDeSaldo;
import Banco.PagoDeServicios;
import Banco.RetiroDeEfectivo;

public class Basic implements ConsultaDeSaldo, PagoDeServicios, RetiroDeEfectivo {
    @Override
    public void consultarSaldo(int cuenta) {
        System.out.println( "Realizando consulta de saldo de la cuenta " + cuenta);
        transaccionOk("consulta de saldo");
    }

    @Override
    public void pagarServicios() {
        System.out.println("Realizando pago de servicios");
        transaccionOk("pago de servicios");
    }

    @Override
    public void retirarEfectivo(int origen, double monto) {
        System.out.println(
                "Realizando retiro de efectivo de " + monto +
                " desde la cuenta " + origen
        );
        transaccionOk("retiro de efectivo");
    }

    @Override
    public void transaccionOk(String tipo) {
        System.out.println("Transaccion de tipo " + tipo + " exitosa :)");
    }

    @Override
    public void transaccionNoOk(String tipo) {
        System.out.println("Transaccion de tipo " + tipo + " fallida :)");
    }
}

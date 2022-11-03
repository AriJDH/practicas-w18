package Paquete;

import Clases.Basic;
import Clases.Cobradores;
import Clases.Ejecutivo;

public class Main {

    public static void main(String[] args) {
	    Basic clienteBasic = new Basic();
	    Ejecutivo clienteEjecutivo = new Ejecutivo();
        Cobradores clienteCobradores = new Cobradores();

        System.out.println(clienteBasic.decirSaldo());
        System.out.println(clienteBasic.pagarServicios());
        System.out.println(clienteBasic.retirarEfectivo());
        System.out.println(clienteBasic.transaccionNoOk());
        System.out.println(clienteBasic.transaccionOk());

        System.out.println(clienteCobradores.decirSaldo());
        System.out.println(clienteCobradores.retirarEfectivo());
        System.out.println(clienteCobradores.transaccionNoOk());
        System.out.println(clienteCobradores.transaccionOk());

        System.out.println(clienteEjecutivo.hacerDeposito());
        System.out.println(clienteEjecutivo.hacerTransferencia());
        System.out.println(clienteEjecutivo.transaccionOk());
        System.out.println(clienteEjecutivo.transaccionNoOk());

    }
}



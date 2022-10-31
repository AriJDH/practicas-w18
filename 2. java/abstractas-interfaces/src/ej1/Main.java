package ej1;

import ej1.clientes.Basic;
import ej1.clientes.Cliente;
import ej1.clientes.Cobrador;
import ej1.clientes.Ejecutivo;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("Basic");
        Basic basic = new Basic();
        basic.realizarConsultaSaldo();
        basic.realizarPagoServicios();
        basic.realizarRetiroEnEfectivo();
        System.out.println();

        System.out.println("Ejecutivo");
        Ejecutivo ejecutivo = new Ejecutivo();
        ejecutivo.realizarDeposito();
        ejecutivo.realizarTransferencia();
        System.out.println();

        System.out.println("Cobrador");
        Cobrador cobrador = new Cobrador();
        cobrador.realizarRetiroEnEfectivo();
        cobrador.realizarConsultaSaldo();
    }
}

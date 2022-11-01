package Main;

import subclase.Basic;
import subclase.Cobradores;
import subclase.Ejecutivo;

public class Main {

    public static void main(String[] args) {

        System.out.println("Ejercicio Banco");
        System.out.println("");

        //Clientes Ejecutivo
        Ejecutivo ejecutivo = new Ejecutivo();
        ejecutivo.realizarDeposito();
        ejecutivo.realizarTransferencia();
        ejecutivo.transaccionOK();
        System.out.println("");

        //Clientes Cobradores
        Cobradores cobradores = new Cobradores();
        cobradores.realizarConsultaSaldo();
        cobradores.realizarRetiroEfectivo();
        cobradores.transaccionOK();
        System.out.println("");


        //Clientes Basic
        Basic basic = new Basic();
        basic.realizarConsultaSaldo();
        basic.realizarPagoServicios();
        basic.realizarRetiroEfectivo();
        basic.transaccionNoOk();

    }

}

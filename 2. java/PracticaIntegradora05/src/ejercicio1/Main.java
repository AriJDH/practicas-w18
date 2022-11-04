package ejercicio1;

import ejercicio1.model.Basic;
import ejercicio1.model.Cobrador;
import ejercicio1.model.Ejecutivo;

public class Main {

    public static void main(String[] args) {

        Basic basic = new Basic();

        basic.hacerConsultaDeSaldo();
        basic.hacerConsultaDeSaldo();
        basic.hacerConsultaDeSaldo();
        basic.hacerConsultaDeSaldo();

        Cobrador cobrador = new Cobrador();

        cobrador.hacerRetiroDeEfectivo(300);
        cobrador.hacerRetiroDeEfectivo(300);
        cobrador.hacerRetiroDeEfectivo(300);
        cobrador.hacerRetiroDeEfectivo(300);

        Ejecutivo ejecutivo = new Ejecutivo();

        ejecutivo.hacerTransferencia(500, "34");
        ejecutivo.hacerTransferencia(500, "34");
        ejecutivo.hacerTransferencia(500, "34");
        ejecutivo.hacerTransferencia(500, "34");

    }

}

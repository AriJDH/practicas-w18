package ejercicio1;

import ejercicio1.clases.Basic;
import ejercicio1.clases.Cobrador;
import ejercicio1.clases.Ejecutivo;

public class Test {
    public static void main(String[] args) {
        Basic basic = new Basic(300);
        basic.consultarSaldo();
        System.out.println("----------------------------------------------------------------------------------------------------------");
        basic.pagarServicio(500);
        System.out.println("----------------------------------------------------------------------------------------------------------");
        basic.pagarServicio(-50);
        System.out.println("----------------------------------------------------------------------------------------------------------");
        basic.retirarDinero(150);
        System.out.println("----------------------------------------------------------------------------------------------------------");
        basic.consultarSaldo();
        System.out.println("----------------------------------------------------------------------------------------------------------");

        Cobrador cobrador = new Cobrador(1500);
        cobrador.retirarDinero(-100);
        System.out.println("----------------------------------------------------------------------------------------------------------");
        cobrador.retirarDinero(10000);
        System.out.println("----------------------------------------------------------------------------------------------------------");
        cobrador.retirarDinero(250);
        System.out.println("----------------------------------------------------------------------------------------------------------");
        cobrador.consultarSaldo();
        System.out.println("----------------------------------------------------------------------------------------------------------");

        Ejecutivo ejecutivo = new Ejecutivo(50000);
        ejecutivo.depositarDinero(-100);
        System.out.println("----------------------------------------------------------------------------------------------------------");
        ejecutivo.depositarDinero(1500);
        System.out.println("----------------------------------------------------------------------------------------------------------");
        ejecutivo.transferirDinero(1000000);
        System.out.println("----------------------------------------------------------------------------------------------------------");
        ejecutivo.transferirDinero(51000);

    }
}

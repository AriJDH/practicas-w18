package practica_abstracta_interfaces_vivo.ejercicio1.clases;

public class Main {

    public static void main(String[] args) {

        System.out.println("===== EJECUTIVO =====");
        Ejecutivo ejecutivo = new Ejecutivo();
        ejecutivo.crearDeposito();
        ejecutivo.crearTransferencia();
        ejecutivo.transaccionOk();

        System.out.println("===== COBRADOR =====");
        Cobrador cobrador = new Cobrador();
        cobrador.consultarSaldo();
        cobrador.transaccionOk();
        cobrador.retirarEfectivo();
    }
}

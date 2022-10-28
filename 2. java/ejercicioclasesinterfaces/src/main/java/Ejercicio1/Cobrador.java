package Ejercicio1;

public class Cobrador implements Transacciones, RetiroEfectivo, ConsultaSaldo {

    @Override
    public void consultaDeSaldo() {
        System.out.println("Consultando el saldo de su cuenta...");
    }

    @Override
    public void retiroDeEfectivo() {
        System.out.println("Retirando efectivo...");
    }

    @Override
    public void transaccionOk(String trans) {
        System.out.println("La transacción " + trans + " ha sido realizada exitosamente.");
    }

    @Override
    public void transaccionNoOk(String trans) {
        System.out.println("Durante la transacción " + trans + " se ha producido un problema.");

    }
}

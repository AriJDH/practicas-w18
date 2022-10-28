package Ejercicio1;

public class Basic implements ConsultaSaldo, PagoServicios, RetiroEfectivo, Transacciones {


    @Override
    public void consultaDeSaldo() {
        System.out.println("Consultando el saldo de su cuenta...");
    }

    @Override
    public void pagoDeServicios() {
        System.out.println("Pagando los servicios correspondientes...");
    }

    @Override
    public void retiroDeEfectivo() {
        System.out.println("Retirando efectivo de su cuenta...");
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


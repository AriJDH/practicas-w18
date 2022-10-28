package Ejercicio1;

public class Ejecutivo implements Deposito,Transferencia,Transacciones{

    @Override
    public void Deposito() {
        System.out.println("Realizando deposito...");
    }

    @Override
    public void transaccionOk(String trans) {
        System.out.println("La transacción " + trans + " ha sido realizada exitosamente.");
    }

    @Override
    public void transaccionNoOk(String trans) {
        System.out.println("Durante la transacción " + trans + " se ha producido un problema.");

    }

    @Override
    public void Transferencia() {
        System.out.println("Realizando transferencia...");
    }
}

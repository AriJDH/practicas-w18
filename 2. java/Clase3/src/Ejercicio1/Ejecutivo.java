package Ejercicio1;

public class Ejecutivo implements Transaccion {

    private float saldo;

    public void realizarDeposito(){
        System.out.println("Deposito");
    }

    public void realizarTransferencias(){
        System.out.println("Transferencia");
    }

    @Override
    public void transaccionOk() {
        System.out.println("Ejercicio1.Transaccion ok");
    }

    @Override
    public void transaccionNoOK() {
        System.out.println("Ejercicio1.Transaccion NO OK");
    }
}

package Transacciones;

public interface Deposito extends Transaccion {

    public void realizarDeposito(){
        System.out.println("Haciendo deposito...");
        System.out.println(transaccionOK());
    }
}

package Transacciones;

public interface Transferencia extends Transaccion {

    public void transferir(){
        System.out.println("Transfiriendo dinero...");
        System.out.println(transaccionOK());
    }
}

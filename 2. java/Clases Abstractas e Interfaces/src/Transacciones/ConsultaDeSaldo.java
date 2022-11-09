package Transacciones;

public interface ConsultaDeSaldo extends Transaccion{

    public void consultarSaldo(){
        System.out.println("Consultando Saldo...");
        System.out.println(transaccionOK());
    }
}

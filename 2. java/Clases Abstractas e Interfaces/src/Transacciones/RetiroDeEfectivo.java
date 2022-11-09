package Transacciones;

public interface RetiroDeEfectivo extends Transaccion{

    public void retirarEfectivo(){
        System.out.println("Retirando Efectivo...");
        System.out.println(transaccionOK());
    }
}

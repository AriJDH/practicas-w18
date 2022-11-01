package Ejercicio1.Transacciones;

public class RetiroEnEfectivo implements Transaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Transaccion ok");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Transaccion no ok");
    }
}

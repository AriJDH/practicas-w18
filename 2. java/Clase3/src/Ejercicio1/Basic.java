package Ejercicio1;

public class Basic implements Transaccion {

    private float saldo;

    public void realizarConsultaSaldo(){
        System.out.println("Consulta de saldo");
    }

    public void pagoDeServicios(){
        System.out.println("Pago de servicios");
    }

    public void retiroEfectivo(){
        System.out.println("Retiro de efectivo");
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

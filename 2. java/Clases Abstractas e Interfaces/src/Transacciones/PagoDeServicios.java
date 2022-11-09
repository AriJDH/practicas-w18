package Transacciones;

public interface PagoDeServicios extends Transaccion {

    public void pagarServicio(){
        System.out.println("Pagando servicio...");
        System.out.println(transaccionOK());
    }
}

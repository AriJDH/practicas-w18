package ejercicio1;

public class Basic implements TransaccionPagoServicio, TransaccionRetiroEfectivo, TransaccionConsultaSaldo {
    @Override
    public void transaccionOk() {
        System.out.println("La transacción se realizó con éxito");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("No se pudo realizar la transacción");
    }
}

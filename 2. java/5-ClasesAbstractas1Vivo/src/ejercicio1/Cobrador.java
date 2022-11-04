package ejercicio1;

public class Cobrador implements TransaccionRetiroEfectivo, TransaccionConsultaSaldo{
    @Override
    public void transaccionOk() {
        System.out.println("Transacción realizada con éxito");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("La transacción no se pudo realizar");
    }
}

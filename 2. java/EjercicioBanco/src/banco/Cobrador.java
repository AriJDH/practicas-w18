package banco;

public class Cobrador implements TransaccionRetiro,TransaccionConsulta{
    @Override
    public void transaccionOK() {
        System.out.println("Transaccion realizada correctamente");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("La transaccion no se pudo realizar");
    }
}

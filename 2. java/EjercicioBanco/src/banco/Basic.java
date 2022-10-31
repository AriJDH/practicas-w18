package banco;

public class Basic implements TransaccionConsulta,TransaccionPago, TransaccionRetiro{
    @Override
    public void transaccionOK() {
        System.out.println("Transaccion realizada correctamente");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("La transaccion no se pudo completar");
    }
}

package ejercicio1;

public class ConsultaDeSaldo implements Transaccion{

    public ConsultaDeSaldo() {
    }

    @Override
    public void transaccionOk() {
        System.out.println("Realizándose consulta de saldo.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Error. La operación no pudo ser realizada.");
    }
}

package transacciones;

public class ConsultaSaldo implements Transaccion{
    @Override
    public void transaccionOk() {
        System.out.println("Consulta realizada con éxito!");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Consulta Fallida! Intente de nuevo.");
    }
}

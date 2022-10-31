package ClasesAbstractas_e_Interfaces.Transacciones;

public class ConsultaSaldo implements Transaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Consulta de saldo exitosa \n");
    }

    @Override
    public void transaccionNotOk() {
        System.out.println("Falló consulta de saldo \n");
    }
}

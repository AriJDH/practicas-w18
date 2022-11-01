package ClasesAbstractas_e_Interfaces.Ejercicio1.Transacciones;

public class ConsultaSaldo implements ITransaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Consulta de saldo exitosa \n");
    }

    @Override
    public void transaccionNotOk() {
        System.out.println("Falló consulta de saldo \n");
    }
}

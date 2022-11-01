package ClasesAbstractas_e_Interfaces.Ejercicio1.Transacciones;

public class RetiroEfectivo implements ITransaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Su retiro fue realizado con éxito \n");
    }

    @Override
    public void transaccionNotOk() {
        System.out.println("Usted no cuenta con los fondos suficientes \n");
    }
}

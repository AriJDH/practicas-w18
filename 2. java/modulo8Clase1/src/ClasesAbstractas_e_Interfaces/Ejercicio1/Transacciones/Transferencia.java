package ClasesAbstractas_e_Interfaces.Ejercicio1.Transacciones;

public class Transferencia implements ITransaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Su transferencia fue realizada con exito \n");
    }

    @Override
    public void transaccionNotOk() {
        System.out.println("Transferencia fallida, por favor ingrese un número de cuenta válido \n");
    }
}

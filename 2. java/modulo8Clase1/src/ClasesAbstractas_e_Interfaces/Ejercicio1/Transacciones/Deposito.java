package ClasesAbstractas_e_Interfaces.Ejercicio1.Transacciones;

public class Deposito implements ITransaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Depósito exitoso \n");
    }

    @Override
    public void transaccionNotOk() {
        System.out.println("No se pudo realizar el depósito, favor comunicarse al 911 \n");
    }



}

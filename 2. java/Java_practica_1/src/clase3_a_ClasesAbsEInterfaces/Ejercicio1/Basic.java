package clase3_a_ClasesAbsEInterfaces.Ejercicio1;

public class Basic implements Consultable, Pagable, Retirable {

    @Override
    public void consultar() {
        transaccionOk("Consulta de Saldo");
    }

    @Override
    public void pagar() {
        transaccionOk("Pago de servicios");
    }

    @Override
    public void retirar() {
        transaccionOk("Retiro");
    }

    @Override
    public void transaccionOk(String tipoTransacc) {
        System.out.println(tipoTransacc + " realizado con éxito!");
    }

    @Override
    public void transaccionNoOk(String tipoTransacc) {
        System.out.println(tipoTransacc + " no se pudo realizar!");
    }
}

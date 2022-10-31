package clase3_a_ClasesAbsEInterfaces.Ejercicio1;

public class Cobradores implements Retirable, Consultable {

    @Override
    public void consultar() {
        transaccionOk("Consulta de Saldo");
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

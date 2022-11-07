import model.Basic;
import model.Cobradores;
import model.Ejecutivo;

public class Main {
    public static void main(String[] args) {
        System.out.println("EJECUTIVOS");

        Ejecutivo ejecutivo = new Ejecutivo();
        ejecutivo.depositar();
        ejecutivo.transaccionOk("DEPOSITO");

        System.out.println("BASIC");
        Basic basic = new Basic();
        basic.consultarSaldo();
        basic.transaccionNoOk("Consulta de Saldo");

        System.out.println("COBRADORES");
        Cobradores cobradores = new Cobradores();
        cobradores.retiroDeEfectivo();
        cobradores.transaccionOk("Retiro de Efectivo");


    }
}
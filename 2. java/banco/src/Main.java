import classes.Basic;
import classes.Cobrador;
import classes.Ejecutivo;

public class Main {
    public static void main(String[] args) {
        Basic basic = new Basic();
        Cobrador cobrador = new Cobrador();
        Ejecutivo ejecutivo = new Ejecutivo();

        basic.realizarConsulta();
        basic.realizarPago(3500);
        basic.realizarRetiro(1000);

        cobrador.realizarConsulta();
        cobrador.realizarRetiro(2000);

        ejecutivo.realizarDeposito(6000);
        ejecutivo.realizarTransferencia(1200);

    }
}

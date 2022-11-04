package Ejercicio1.Interfaces.Clases;

import Ejercicio1.Interfaces.ConsultaSaldo;
import Ejercicio1.Interfaces.RetiroEF;

public class Cobradores implements RetiroEF, ConsultaSaldo {
    public Cobradores() {
    }

    @Override
    public void consultaDeSaldo() {
        System.out.println("Tú salgo es de $#'###.###");
        this.transaccionOK("consulta de saldo");
    }

    @Override
    public void retiroDeEfectivo(double cantidadARetirar) {
        System.out.println("Se ha débitado de tu cuenta el valor de "+ cantidadARetirar + " con éxito");
        this.transaccionNoOK("Retiro de efectivo");
    }

    @Override
    public void transaccionOK(String tipoTransaccion) {
        System.out.println("Transacción de "+ tipoTransaccion + " realizado con éxito");
    }

    @Override
    public void transaccionNoOK(String tipoTransaccion) {
        System.out.println("Transacción "+ tipoTransaccion + " no es posible");
    }
}

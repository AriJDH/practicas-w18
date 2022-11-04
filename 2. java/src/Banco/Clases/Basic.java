package Banco.Clases;

import Banco.Interfaces.ConsultaSaldo;
import Banco.Interfaces.PagoServicios;
import Banco.Interfaces.RetiroEF;

public class Basic implements PagoServicios, RetiroEF, ConsultaSaldo {
        public Basic() {
        }

        @Override
        public void consultaDeSaldo() {
            System.out.println("Tú saldo es de $#'###.###");
            this.transaccionOK("Consulta de saldo");
        }

        @Override
        public void pagoDeServicios(double valorAPagar) {
            System.out.println("El pago de "+ valorAPagar + " realizado con éxito");
        }

        @Override
        public void retiroDeEfectivo(double cantidadARetirar) {
            System.out.println("Se ha débitado de tu cuenta el valor de "+ cantidadARetirar + " con éxito");
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

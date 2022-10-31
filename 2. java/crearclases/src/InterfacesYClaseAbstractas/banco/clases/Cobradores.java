package InterfacesYClaseAbstractas.banco.clases;

import InterfacesYClaseAbstractas.banco.interfaces.ConsultarSaldo;
import InterfacesYClaseAbstractas.banco.interfaces.Extracciones;

public class Cobradores implements Extracciones, ConsultarSaldo {

    @Override
    public void consultarSaldo() {
        System.out.println("consulta de saldo");
    }

    @Override
    public void extraerEfectivo(double monto) {
        System.out.println("extracción de dinero en efectivo por el monto " + monto);
    }

    @Override
    public void transaccionesOk(String transaccion) {
        System.out.println("transacción aprobada");
    }

    @Override
    public void transaccionesNoOk(String transaccion) {
        System.out.println("transacción no aprobada");
    }
}

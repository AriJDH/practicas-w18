package InterfacesYClaseAbstractas.banco.clases;

import InterfacesYClaseAbstractas.banco.interfaces.ConsultarSaldo;
import InterfacesYClaseAbstractas.banco.interfaces.Extracciones;
import InterfacesYClaseAbstractas.banco.interfaces.PagarServicios;


public class Basic implements ConsultarSaldo, PagarServicios, Extracciones {
    @Override
    public void consultarSaldo() {
        System.out.println("se hace una consulta de saldo");
    }

    @Override
    public void extraerEfectivo(double monto) {
        System.out.println("extracciones de dinero en efectivo");
    }

    @Override
    public void pagarServicio(String servicio, Double monto) {
        System.out.println("pago de servicios");
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

package subclase;

import Interfaces.ConsultaSaldo;
import Interfaces.PagoServicios;
import Interfaces.RetiroEfectivo;
import superclase.Cliente;

public class Basic extends Cliente implements ConsultaSaldo, PagoServicios, RetiroEfectivo {
    @Override
    public void transaccionOK() {
        System.out.println("La transacción se ha realizado correctamente");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("La transacción NO se ha realizado correctamente");
    }

    @Override
    public void realizarPagoServicios() {
        System.out.println("Se está realizando el pago de servicio");
    }

    @Override
    public void realizarConsultaSaldo() {
        System.out.println("Se está realizando la consulta del saldo");
    }

    @Override
    public void realizarRetiroEfectivo() {
        System.out.println("Se está retirando el efectivo");
    }
}

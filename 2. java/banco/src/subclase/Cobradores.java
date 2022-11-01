package subclase;

import Interfaces.ConsultaSaldo;
import Interfaces.RetiroEfectivo;
import superclase.Cliente;

public class Cobradores extends Cliente implements RetiroEfectivo, ConsultaSaldo {
    @Override
    public void transaccionOK() {
        System.out.println("La transacción se ha realizado correctamente");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("La transacción NO se ha realizado correctamente");
    }

    @Override
    public void realizarRetiroEfectivo() {
        System.out.println("Se está retirando el efectivo");
    }

    @Override
    public void realizarConsultaSaldo() {
        System.out.println("Se está realizando la consulta del saldo");
    }
}

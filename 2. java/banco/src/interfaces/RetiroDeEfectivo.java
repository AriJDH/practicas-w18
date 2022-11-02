package interfaces;

import interfaces.Transaccion;

public interface RetiroDeEfectivo extends Transaccion {

    public void realizarRetiro(double importe);

}

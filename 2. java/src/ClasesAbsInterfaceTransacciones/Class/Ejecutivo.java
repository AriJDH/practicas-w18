package ClasesAbsInterfaceTransacciones.Class;

import ClasesAbsInterfaceTransacciones.Interface.IDeposito;
import ClasesAbsInterfaceTransacciones.Interface.ITransferencia;

public class Ejecutivo implements IDeposito, ITransferencia {

    @Override
    public void depositarMonto(boolean test) {
        System.out.printf("Intentado hacer deposito....");
        if (test)
            transaccionOk();
        else
            transaccionNoOK();
    }

    @Override
    public void transaccionOk() {
        System.out.printf("Se realizo la trnasaccion");
    }

    @Override
    public void transaccionNoOK() {
        System.out.printf("No se realizo la transaccion");

    }

    @Override
    public void realizarTransferencia(boolean test) {
        System.out.printf("Intentando hacer transferencia....");
        if (test)
            transaccionOk();
        else
            transaccionNoOK();
    }
}

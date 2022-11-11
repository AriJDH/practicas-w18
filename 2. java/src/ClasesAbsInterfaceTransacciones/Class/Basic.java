package ClasesAbsInterfaceTransacciones.Class;

import ClasesAbsInterfaceTransacciones.Interface.IConsultaSaldo;
import ClasesAbsInterfaceTransacciones.Interface.IPagoServicio;
import ClasesAbsInterfaceTransacciones.Interface.IRetiroEfectivo;

public class Basic implements IRetiroEfectivo, IPagoServicio, IConsultaSaldo {
    @Override
    public void consutlarSaldo(boolean test) {
        System.out.printf("Intentando consultar el saldo...");
        if(test)
            transaccionOk();
        else
            transaccionNoOK();
    }

    @Override
    public void pagarServicio(boolean test) {
        System.out.printf("Intentando pagar servicio...");
        if(test)
            transaccionOk();
        else
            transaccionNoOK();
    }

    @Override
    public void retirarEfectivo(boolean test) {
        System.out.printf("Intentando retirar efectivo...");
        if(test)
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
        System.out.printf("No se realizo la trnasaccion");
    }
}

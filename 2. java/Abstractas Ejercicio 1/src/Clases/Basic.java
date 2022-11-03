package Clases;

import Interfaces.ConsultaSaldo;
import Interfaces.PagoServicios;
import Interfaces.RetiroEfectivo;

public class Basic implements ConsultaSaldo, PagoServicios, RetiroEfectivo {

    @Override
    public String decirSaldo() {
        return "Su saldo es...";
    }

    @Override
    public String pagarServicios() {
        return "Pagando servicios...";
    }

    @Override
    public String retirarEfectivo() {
        return "Retirando efectivo...";
    }

    @Override
    public String transaccionOk() {
        return "Su consulta/pago/retiro fue exitoso";
    }

    @Override
    public String transaccionNoOk() {
        return "Su consulta/pago/retiro fue rechazado";
    }
}


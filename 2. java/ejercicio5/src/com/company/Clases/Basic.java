package com.company.Clases;

import com.company.Interfaces.PagoServicios;
import com.company.Interfaces.RetiroEfectivo;
import com.company.Interfaces.Saldo;

public class Basic implements Saldo, PagoServicios, RetiroEfectivo {
    @Override
    public void transaccionOk(String tipoTransacc) {

    }

    @Override
    public void transaccionNoOk(String tipoTransacc) {

    }

    @Override
    public void consultarSaldo() {

    }
}

package com.company.Clases;

import com.company.Interfaces.RetiroEfectivo;
import com.company.Interfaces.Saldo;

public class Cobradores implements RetiroEfectivo, Saldo {

    @Override
    public void transaccionOk(String tipoTransacc) {

    }

    @Override
    public void transaccionNoOk(String tipoTransacc) {

    }
}

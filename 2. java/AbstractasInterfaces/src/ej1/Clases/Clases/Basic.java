package ej1.Clases.Clases;

import ej1.Clases.Interfaces.Consulta;
import ej1.Clases.Interfaces.Pago;
import ej1.Clases.Interfaces.Retiro;
import ej1.Clases.Interfaces.Transacciones;

import java.util.Random;

public class Basic implements Transacciones, Consulta, Pago, Retiro {
    Random rand = new Random();
    int value = rand.nextInt((250000 - 15000) + 1) + 15000;

    @Override
    public String consultaDeSaldo() {
        return "Saldo: $" + value;
    }

    @Override
    public String pagoDeServicios(String servicio) {
        return "El servicio " + servicio + " fue abonado correctamente";
    }

    @Override
    public String retiroDeEfectivo(double amount) {
        return amount + " fueron retirados correctamente";
    }

    @Override
    public String transaccionOk(String tipoTransf) {
        return tipoTransf + " realizada correctamente";
    }

    @Override
    public String transaccionNoOk(String tipoTransf) {
        return tipoTransf + " tuvo un error";
    }
}

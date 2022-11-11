package ej1.Clases.Clases;

import ej1.Clases.Interfaces.Consulta;
import ej1.Clases.Interfaces.Retiro;
import ej1.Clases.Interfaces.Transacciones;

import java.util.Random;

public class Cobradores implements Transacciones, Retiro, Consulta {
    Random rand = new Random();
    int value = rand.nextInt((250000 - 15000) + 1) + 15000;

    @Override
    public String consultaDeSaldo() {
        return "Saldo: $" + value;
    }

    @Override
    public String retiroDeEfectivo(double amount) {
        return amount + " retirados correctamente";
    }

    @Override
    public String transaccionOk(String tipoTransf) {
        return tipoTransf + " efectuada correctamente";
    }

    @Override
    public String transaccionNoOk(String tipoTransf) {
        return tipoTransf + "tuvo un problema";
    }
}

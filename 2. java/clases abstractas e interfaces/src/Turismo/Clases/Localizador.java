package Turismo.Clases;

import Turismo.Interfaces.ICalculable;

import java.util.ArrayList;
import java.util.List;

public class Localizador implements ICalculable {
    Cliente Cliente;
    List<Reserva> Reservas;

    @Override
    public double valorTotal(double valor) {
        return 0;
    }
}

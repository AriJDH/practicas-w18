package Models.EstrategiaDescuento;

import Models.Cliente;
import Models.Localizador;

import java.util.Collections;
import java.util.List;

public class DescuentoCantidadLocalizador implements IEstrategiaDescuento{

    private int cantidadDeLocalizadores;

    @Override
    public double calcularDescuento(List<Localizador> localizadores, Cliente cliente) {
        int occurrencesClientInLocalizador = Collections.frequency(localizadores, cliente);
        if (occurrencesClientInLocalizador > cantidadDeLocalizadores)
            return 0.05;
        return 1.0;
    }

    public int getCantidadDeLocalizadores() {
        return cantidadDeLocalizadores;
    }

    public void setCantidadDeLocalizadores(int cantidadDeLocalizadores) {
        this.cantidadDeLocalizadores = cantidadDeLocalizadores;
    }
}

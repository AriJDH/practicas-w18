package Models.EstrategiaDescuento;

import Models.Cliente;
import Models.Localizador;

import java.util.List;

public class DescuentoPaqueteCompleto implements IEstrategiaDescuento{

    @Override
    public double calcularDescuento(List<Localizador> localizadores, Cliente cliente) {
        return 0;
    }
}

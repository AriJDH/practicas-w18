package Models.EstrategiaDescuento;
import Models.Cliente;
import Models.Localizador;

import java.util.List;

public interface IEstrategiaDescuento {
    double calcularDescuento(List<Localizador> localizadores, Cliente cliente);

}

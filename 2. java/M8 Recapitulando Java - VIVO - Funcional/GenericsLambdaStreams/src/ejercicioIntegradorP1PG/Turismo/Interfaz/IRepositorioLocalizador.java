package ejercicioIntegradorP1PG.Turismo.Interfaz;

import ejercicioIntegradorP1PG.Turismo.Model.Cliente;
import ejercicioIntegradorP1PG.Turismo.Model.Localizador;

public interface IRepositorioLocalizador {

    void almacenarLocalizador(Localizador localizadores);

    void imprimirLocalizadorGenerado(Localizador localizador);

    int descuentoPorCliente(Cliente cliente);

    void agregarCliente(Cliente cliente);

}

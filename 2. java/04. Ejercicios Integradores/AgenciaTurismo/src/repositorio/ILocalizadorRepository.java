package repositorio;

import modelo.Cliente;
import modelo.Localizador;

import java.util.Set;

public interface ILocalizadorRepository extends IRepository<Localizador> {
    Set<Localizador> getByCliente(Cliente cliente);
}

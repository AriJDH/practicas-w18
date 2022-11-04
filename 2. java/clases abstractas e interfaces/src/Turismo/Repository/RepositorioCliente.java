package Turismo.Repository;

import Turismo.Clases.Cliente;
import Turismo.Interfaces.IRepository;

import java.util.ArrayList;
import java.util.List;

public class RepositorioCliente implements IRepository<Cliente> {
    List<Cliente> listaClientes = new ArrayList<>();

    @Override
    public Cliente create(Cliente cliente) {
        return null;
    }

    @Override
    public void delete(Cliente cliente) {

    }

    @Override
    public Cliente find(Cliente cliente) {
        return null;
    }

    @Override
    public Cliente update(Cliente anterior, Cliente nuevo) {
        return null;
    }

    @Override
    public Iterable<Cliente> findAll() {
        return null;
    }
}

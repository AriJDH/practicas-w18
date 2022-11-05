package EjIntegradorVivo.Repositorio;

import EjIntegradorVivo.Clases.Cliente;
import EjIntegradorVivo.IClienteRepositorio.IRepositorio;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class RepositorioCliente implements IRepositorio<Cliente> {
    List<Cliente> listaClientes;
    private static final AtomicInteger count = new AtomicInteger(0);

    public RepositorioCliente() {
        this.listaClientes = new ArrayList<>();
    }

    @Override
    public Long create(Cliente cliente) {
        if (cliente.getId() == null) {
            Cliente clienteNuevo = new Cliente(cliente.getNombre());
            clienteNuevo.setId(count.incrementAndGet());
            this.listaClientes.add(clienteNuevo);
            return count.longValue();
        } else {
            throw new IllegalArgumentException(String.format(""));
        }
    }

    @Override
    public Cliente findOne(long id) {
        for (Cliente cli : this.listaClientes) {
            if (cli.getId() == id) {
                return cli;
            }
        }
        return null;
    }

    @Override
    public List<Cliente> findAll() {
        return this.listaClientes;
    }

    @Override
    public void delete(long id) {
        boolean delete = listaClientes.removeIf(cliente -> cliente.getId() == id);
        if (!delete) {
            throw new IllegalArgumentException(String.format("No se puede borrar el id %d porque no existe", id));
        }
    }

    @Override
    public Cliente update(Cliente updateClient) {
        for (Cliente storedClient : listaClientes) {
            if (storedClient.getId().equals(updateClient.getId())) {
                storedClient.setLocalizadores(updateClient.getLocalizadores());
                return updateClient;
            }
        }
        return null;
    }

}

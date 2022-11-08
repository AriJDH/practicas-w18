package repository;

import model.Cliente;

import java.util.List;

public class RepositorioCliente implements IRepositorio<Cliente> {

    // Atributos
    private List<Cliente> clientes;

    @Override
    public void agregar(Cliente cliente) {
        clientes.add(cliente);
    }

    @Override
    public List<Cliente> buscarTodos() {
        return clientes;
    }

    @Override
    public Cliente buscarId(Long id) {
        Cliente clienteEncontrado = null;
        for (Cliente cliente : clientes
        ) {
            if (cliente.getId().equals(id)) {
                clienteEncontrado = cliente;
            }
        }
        return clienteEncontrado;
    }

    @Override
    public void eliminar(Long id) {
        Cliente clienteEncontrado = this.buscarId(id);
        this.clientes.remove(clienteEncontrado);
    
    }
}

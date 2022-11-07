package repositorio;

import modelo.Cliente;

import java.util.HashSet;
import java.util.Set;

public class ClienteRepository implements IClienteRepository{
    Set<Cliente> clientes =new HashSet<>();

    @Override
    public void add(Cliente cliente) {
        this.clientes.add(cliente);
    }

    @Override
    public Set<Cliente> getAll() {
        return this.clientes;
    }

    @Override
    public Cliente getOne(Long id) {
        return this.clientes.stream().filter(c->c.getId().equals(id)).findFirst().orElseThrow(()->new RuntimeException("No existe Cliente"));
    }
}

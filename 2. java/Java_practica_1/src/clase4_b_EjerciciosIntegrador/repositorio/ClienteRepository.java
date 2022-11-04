package clase4_b_EjerciciosIntegrador.repositorio;

import clase4_b_EjerciciosIntegrador.modelo.Cliente;

import java.util.HashSet;
import java.util.Set;

public class ClienteRepository implements IClienteRepository{
    Set<Cliente> clientes = new HashSet<>();

    @Override
    public void add(Cliente clientes) {
        this.clientes.add(clientes);
    }

    @Override
    public Set<Cliente> getAll() {
        return this.clientes;
    }

    @Override
    public Cliente getOne() {
        return null;
    }



}

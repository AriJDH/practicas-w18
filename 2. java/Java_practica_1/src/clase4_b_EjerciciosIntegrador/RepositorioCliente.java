package clase4_b_EjerciciosIntegrador;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class RepositorioCliente implements IRepositorio<Cliente>{

    private Set<Cliente> clienteList;
    @Override
    public void agregar(Cliente cliente) {
        clienteList.add(cliente);
    }

    @Override
    public Set<Cliente> traerTodos() {
        return clienteList;
    }

    public RepositorioCliente() {
        this.clienteList = new HashSet<>();
    }
}

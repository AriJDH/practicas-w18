package clase4_b_EjerciciosIntegrador;

import java.util.ArrayList;
import java.util.List;

public class RepositorioCliente implements IRepositorio<Cliente>{

    private List<Cliente> clienteList;
    @Override
    public void agregar(Cliente cliente) {
        clienteList.add(cliente);
    }

    @Override
    public List<Cliente> listarTodos() {
        return clienteList;
    }

    public RepositorioCliente() {
        this.clienteList = new ArrayList<>();
    }
}

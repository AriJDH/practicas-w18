package clases;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RepositorioClientes {

    private List<Cliente> clientes = new ArrayList<>();

    public RepositorioClientes() {
    }

    public void guardarCliente(Cliente cliente){

        if (encontrarPorDni(cliente.getDni()).isEmpty()){
            clientes.add(cliente);
        }

    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void eliminarCliente() {
        clientes.remove(0);
    }

    public Optional<Cliente> encontrarPorDni(Long dni) {
        try {
            Optional<Cliente> resultado = clientes.stream()
                    .filter(cliente -> cliente.getDni() == dni)
                    .findFirst();
            return resultado;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}

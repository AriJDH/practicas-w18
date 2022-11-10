package repository;

import model.Cliente;
import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClienteImp implements CRUDRepository<Cliente> {

    private List<Cliente> listaClientes = new ArrayList<Cliente>();

    @Override
    public void create(Cliente cliente) {
        listaClientes.add(cliente);
    }

    @Override
    public void mostrarPorPantalla() {
        listaClientes.stream().forEach(System.out::println);
    }

    @Override
    public Optional<Cliente> getById(String dni) {
        return listaClientes.stream().filter(c -> dni.equals(c.getDni())).findAny();
    }

    @Override
    public void delete(String dni) {
        Optional<Cliente> cliente = this.getById(dni);

        if(cliente.isEmpty()) {
            System.out.println("No se encontró el cliente");
        } else {
            listaClientes.remove(cliente.get());
            System.out.println("Cliente borrado");
        }
    }

    @Override
    public List getAll() {
        return listaClientes;
    }
}

package repository;

import model.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteImpl implements CRUDRepository<Cliente> {

    // Nuestra base de clientes
    List<Cliente> clientes = new ArrayList<>();


    // Implementación de métodos
    @Override
    public void guardar(Cliente cliente) {
        clientes.add(cliente);
        System.out.println("El cliente fue agregado");
    }

    @Override
    public void mostrarTodos() {
        System.out.println("--------- Listado de Clientes ---------");
        clientes.forEach(System.out::println);
    }

    @Override
    public Cliente buscarPorId(Long dni) {
        Cliente clienteEncontrado = null;
        for (Cliente cliente : clientes) {
            if (cliente.getDni().compareTo(dni) == 0) {
                clienteEncontrado = cliente;
                System.out.println("El cliente encontrado es " + cliente);
            }
        }
        if (clienteEncontrado == null) {
            System.out.println("No se pudo encontrar el cliente");
        }
        return clienteEncontrado;
    }

    @Override
    public void eliminarPorId(Long dni) {
        Cliente clienteEncontrado = buscarPorId(dni);
        if (clienteEncontrado != null) {
            clientes.remove(clienteEncontrado);
            System.out.println("El cliente fue eliminado");
        } else System.out.println("El cliente no pudo ser eliminado");

    }

    @Override
    public List<Cliente> listarTodos() {
        return clientes;
    }
}

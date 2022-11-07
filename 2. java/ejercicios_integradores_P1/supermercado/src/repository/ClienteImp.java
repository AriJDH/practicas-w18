package repository;

import model.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClienteImp implements CRUDrepository<Cliente>{

    List<Cliente> clientes = new ArrayList<Cliente>();


    @Override
    public void save(Object obj) {
        clientes.add((Cliente) obj);
    }

    @Override
    public void mostrar() {
        clientes.stream().forEach(System.out::println);
    }

    @Override
    public Optional<Cliente> buscar(String dni) {
        for (Cliente c: clientes) {
            if (c.getDni().equals(dni)){
                return Optional.of(c);
            }
        }
        return Optional.empty();
    }

    @Override
    public void eliminar(String dni) {
        Optional<Cliente> cliente = this.buscar(dni);
        if (cliente.isEmpty()){
            System.out.println("No se encontró el cliente");
        }else{
            clientes.remove(cliente);
            System.out.println("Cliente eliminado exitosamente");
            clientes.stream().forEach(System.out::println);
        }

    }

    @Override
    public List<Cliente> traerTodos() {
        return clientes;
    }
}

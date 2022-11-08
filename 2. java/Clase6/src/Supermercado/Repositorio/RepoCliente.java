package Supermercado.Repositorio;

import Supermercado.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class RepoCliente implements IRepositorio <Cliente> {
    List<Cliente> listaClientes;
    private static final AtomicInteger count = new AtomicInteger(0);

    public RepoCliente() {
        this.listaClientes = new ArrayList<>();
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    @Override
    public Cliente create(Cliente cliente) {
        if(cliente.getId() == null){
            Cliente nuevoCliente = new Cliente(cliente.getDni(), cliente.getNombre(), cliente.getApellido());
            long id = count.incrementAndGet();
            nuevoCliente.setId(id);
            this.listaClientes.add(nuevoCliente);
            cliente.setId(id);
            return cliente;
        }else{
            throw new IllegalArgumentException(String.format("El cliente ya existe en la lista"));
        }
    }

    @Override
    public Cliente update(Cliente cliente) {
        for(Cliente storedClient: listaClientes){
            if(storedClient.getId() == cliente.getId()){
                storedClient.setNombre(cliente.getNombre());
                return cliente;
            }
        }
        return null;
    }

    @Override
    public Cliente read(Long id) {
        for(Cliente storedClient : listaClientes){
            if(storedClient.getId() == id){
                return storedClient;
            }
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        boolean delete = listaClientes.removeIf(c -> c.getId() == id);
        if (!delete) {
            throw new IllegalArgumentException(String.format("No se puede borrar el id %d porque no existe", id));
        }
    }
}
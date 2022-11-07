package repository;

import model.Cliente;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class ClienteRepository implements CrudRepository <Cliente> {


    List<Cliente> clienteList = new ArrayList<>();

    @Override
    public void create(Cliente objectT) {
        clienteList.add(objectT);
    }

    @Override
    public Optional<Cliente> retrieve(int dni) {
        return clienteList.stream().filter(x -> x.getDni() == dni).findFirst();
    }

    @Override
    public List<Cliente> retrieveAll() {
        return clienteList;
    }

    @Override
    public void printAll() {
        clienteList.forEach(System.out::println);
    }

    @Override
    public Boolean update(int dni, Cliente cliente) {
        return retrieve(dni).filter(value -> Collections.replaceAll(clienteList, value, cliente)).isPresent();
    }

    @Override
    public void delete(int dni) {
        retrieve(dni).ifPresent(cliente -> clienteList.remove(cliente));
    }
}

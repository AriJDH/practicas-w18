package repository;

import clases.Cliente;
import interfaces.IRepository;

import java.util.ArrayList;

public class ClienteRepository  implements IRepository {
    private ArrayList<Cliente> clientes;

    public ClienteRepository() {
        this.clientes = new ArrayList<>();
    }

    @Override
    public boolean create() {
        return false;
    }

    @Override
    public Object getById() {
        return null;
    }

    @Override
    public Object getAll() {
        return null;
    }

    @Override
    public boolean delete(Object o) {
        return false;
    }
}

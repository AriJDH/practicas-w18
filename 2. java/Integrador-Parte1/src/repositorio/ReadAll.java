package repositorio;

import model.Cliente;

import java.util.List;

public interface ReadAll<T> {

    void findAll(Cliente cliente);
}

package interfaces;

import clases.Cliente;

import java.util.ArrayList;
import java.util.List;

public interface Guardable {

    List<Cliente> clientes = new ArrayList<>();

    static void guardarCliente(Cliente cliente) {
        clientes.add(cliente);
    }
}

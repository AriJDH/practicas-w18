package Repositorio;

import Clases.Cliente;

import java.util.ArrayList;
import java.util.List;

public class BaseDatos {

    private List<Cliente> listaClientes = new ArrayList<Cliente>();

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public void agregar (Cliente cliente) {
        listaClientes.add(cliente);
    }

    public void eliminar (Cliente cliente) {
        listaClientes.remove(cliente);
    }

    public void mostrarTodos() {
        for (Cliente cliente: listaClientes) {
            System.out.println(cliente);
        }
    }


}

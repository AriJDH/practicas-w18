package Repositorio;

import Clases.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import static java.util.Optional.empty;

public class ClienteImp implements CRUD <Cliente> {

    List<Cliente> listaClientes = new ArrayList<Cliente>();
    @Override
    public void guardar(Cliente cliente) {
        listaClientes.add(cliente);
    }

    @Override
    public void imprimir() {
        for(Cliente cliente: listaClientes) {
            System.out.println(cliente.toString());
        }
    }

    @Override
    public Optional<Cliente> buscar(int dni) {
        boolean bandera =false;

        for(Cliente cliente: listaClientes) {
            if (cliente.getDni()==dni) {
                System.out.println(cliente.toString());
                bandera=true;
                return  Optional.of(cliente);   //Retorna un cliente. Es necesario para las otras clases y eliminado
            }
        }

        if (bandera==false) {
            System.out.println("No se encuentra ningun cliente asociado a este Dni");
        }
        return Optional.empty();
    }

    @Override
    public void eliminar(int dni2) {
        Optional<Cliente> cliente = this.buscar(dni2);

        if (cliente.isEmpty()) {
            System.out.println("No se encuentra ningun cliente asociado a este Dni");
        } else {
            System.out.println("Cliente borrado");
            listaClientes.remove(cliente.get());
        }
    }

    @Override
    public List<Cliente> traerTodos() {
        return listaClientes;
    }
}

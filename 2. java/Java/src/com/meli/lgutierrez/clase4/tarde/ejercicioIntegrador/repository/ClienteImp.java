package com.meli.lgutierrez.clase4.tarde.ejercicioIntegrador.repository;

import com.meli.lgutierrez.clase4.tarde.ejercicioIntegrador.model.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClienteImp implements CRUDRepository<Cliente, Integer> {

    private List<Cliente> clientes;

    public ClienteImp() {
        this.clientes = new ArrayList<>();
    }

    public void agregar(Cliente cliente){
        this.clientes.add(cliente);
        System.out.println("El cliente " + cliente.getNombre() + " se ha agregado exitosamente.");
    }
    public void mostrar(){
        clientes.stream().forEach(System.out::println);
    }

    public void eliminar(Integer dni){
        Optional<Cliente> cliente = buscar(dni);

        if (cliente.isEmpty()){
            System.out.println("Cliente no encontrado");
        }else {
            this.clientes.remove(cliente.get());
            System.out.println("El cliente " + cliente.get().getNombre() + " se eliminado exitosamente.");
        }
    }

    public Optional<Cliente> buscar(Integer dni){
        return clientes.stream().filter(cliente -> cliente.getDni().equals(dni)).findFirst();

    }
}

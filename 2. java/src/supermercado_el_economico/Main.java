package supermercado_el_economico;

import supermercado_el_economico.model.Cliente;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Cliente c1 = new Cliente("12345654", "Carlos Perez");
        Cliente c2 = new Cliente("43877177", "Camila Lopez");
        Cliente c3 = new Cliente("01929383", "Lucila Robles");

        List<Cliente> clientes = new ArrayList<>();

        clientes.add(c1);
        clientes.add(c2);
        clientes.add(c3);

        System.out.println("******************** Clientes completos ********************");
        mostrarClientes(clientes);

        eliminarCliente(clientes, c2);

        System.out.println("*************** Clientes despues de borrar 1 ***************");
        mostrarClientes(clientes);

    }

    public static void mostrarClientes(List<Cliente> clientes){
        for (Cliente c: clientes)
            System.out.println(c);
    }

    public static void eliminarCliente(List<Cliente> lista, Cliente c){
        lista.remove(c);
    }

    public static void buscarCliente(List<Cliente> lista, String dni){
        Cliente aux = null;
        int i = 0;
        while(i < lista.size() && aux == null){

        }
    }
}

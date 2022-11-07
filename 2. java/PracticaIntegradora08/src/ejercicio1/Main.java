package ejercicio1;

import ejercicio1.model.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {

        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente(12456789, "Pedro", "Perez"));
        clientes.add(new Cliente(98654321, "Maria", "Marlo"));
        clientes.add(new Cliente(34679125, "Laura", "Lazlo"));


        imprimirClientes(clientes);

        clientes.remove(1);

        imprimirClientes(clientes);

        encontrarClientePorDni(clientes, 12456789);
    }

    public static void imprimirClientes(List<Cliente> clienteList) {

        System.out.println();
        System.out.println("Clientes:");
        System.out.println("-----------------------------------------------------------");
        clienteList.forEach(System.out::println);
        System.out.println();
    }

    public static void encontrarClientePorDni(List<Cliente> clienteList, Integer dni) {

        Optional<Cliente> opCliente = clienteList.stream().filter(cliente -> cliente.getDni().equals(dni)).findFirst();
        if (opCliente.isPresent()) {

            System.out.println();
            System.out.println("Cliente encontrado:");
            System.out.println(opCliente.get().toString());
            System.out.println();
        } else {

            System.out.println();
            System.out.println("INFO: Cliente con DNI: " + dni + " no Encontrado !");
            System.out.println();
        }
    }

}

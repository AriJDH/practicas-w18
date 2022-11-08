package clase4_a_EjerciciosIntegrador.Ej3_Supermercado.repository;
import clase4_a_EjerciciosIntegrador.Ej3_Supermercado.model.Cliente;

import java.util.HashSet;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;

public class ClienteImp implements CRUDRepository<Cliente> {

    private Scanner teclado = new Scanner(System.in);
    Set<Cliente> setClientes = new HashSet<>();
    @Override
    public Cliente nuevo(){
        String dni, nombre, apellido;
        System.out.println("--------------------------------------------------------------------");
        System.out.println("Nuevo cliente");
        System.out.println("--------------------------------------------------------------------");
        System.out.print("DNI: ");
        dni = teclado.nextLine();
        System.out.print("Nombre: ");
        nombre = teclado.nextLine();
        System.out.print("Apellido: ");
        apellido = teclado.nextLine();
        Cliente cliente = new Cliente(dni,nombre,apellido);
        nuevo(cliente);
        System.out.println("\nPresione una tecla para continuar...");
        teclado.nextLine();
        return cliente;
    }


    @Override
    public void nuevo(Cliente cliente) {
        setClientes.add(cliente);
    }

    @Override
    public void mostrarTodos() {
        System.out.println("--------------------------------------------------------------------");
        System.out.println("Listado de clientes");
        System.out.println("--------------------------------------------------------------------");
        setClientes.stream().forEach(System.out::println);
        System.out.println("\nPresione una tecla para continuar...");
        teclado.nextLine();
    }

    @Override
    public void eliminar(Cliente cliente) {
        setClientes.remove(cliente);
    }

    @Override
    public void eliminar() {
        String dni;
        System.out.println("--------------------------------------------------------------------");
        System.out.printf("Ingrese un DNI para buscar el cliente a eliminar: ");
        dni = teclado.nextLine();
        System.out.println("--------------------------------------------------------------------");
        Optional<Cliente> cliente = buscar(dni);
        if (cliente.isPresent()){
            eliminar(cliente.get());
            mostrarTodos();
        }else{
            System.out.println("No se encontró el cliente con DNI " + dni);
            System.out.println("\nPresione una tecla para continuar...");
            teclado.nextLine();
        }
    }

    @Override
    public void mostrarUno() {
        String dni;
        System.out.println("--------------------------------------------------------------------");
        System.out.printf("Ingrese un DNI para buscar el cliente a mostrar: ");
        dni = teclado.nextLine();
        System.out.println("--------------------------------------------------------------------");
        Optional<Cliente> cliente = buscar(dni);
        if (cliente.isPresent()){
            System.out.println(cliente.get());
        }else{
            System.out.println("No se encontró el cliente con DNI " + dni);
        }
        System.out.println("\nPresione una tecla para continuar...");
        teclado.nextLine();
    }

    @Override
    public Optional<Cliente> buscar(String dni) {
        return setClientes.stream().filter(c-> c.getDni().equals(dni)).findFirst();
    }
}

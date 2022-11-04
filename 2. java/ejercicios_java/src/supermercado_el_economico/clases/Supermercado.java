package supermercado_el_economico.clases;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Supermercado {

    private static List<Cliente> clientes;

    public static void main(String[] args) {

        clientes = new ArrayList<>();

        while (true) {

            System.out.println("======SUPERMERCADO 'El economico'======");

            System.out.println("1) Crear cliente");
            System.out.println("2) Eliminar cliente");
            System.out.println("3) Consultas clientes");
            System.out.println("4) Consultas cliente por identificacion");
            System.out.println("5) Salir");

            Scanner teclado = new Scanner(System.in);

            int opcionMenu = teclado.nextInt();

            boolean salirMenu = false;

            switch (opcionMenu) {
                case 1:
                    crearCliente();
                    break;
                case 2:
                    eliminarCliente();
                    break;
                case 3:
                    consultarClientes();
                    break;
                case 4:
                    consultarClienteDni();
                    break;
                case 5:
                    salirMenu = true;
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }

            if (salirMenu) {
                break;
            }
        }
    }

    private static void crearCliente() {

        Scanner teclado = new Scanner(System.in);

        System.out.print("Ingresar dni: ");
        String dni = teclado.nextLine();

        System.out.print("Ingresar nombre: ");
        String nombre = teclado.nextLine();

        System.out.print("Ingresar apellido: ");
        String apellido = teclado.nextLine();

        Cliente cliente = new Cliente();
        cliente.setDni(dni);
        cliente.setNombre(nombre);
        cliente.setApellido(apellido);

        clientes.add(cliente);
    }

    private static void consultarClientes() {

        System.out.println("====== Clientes registrados ======");
        clientes.forEach(System.out::println);
    }

    private static void eliminarCliente() {

        System.out.println("====== Eliminacion cliente ========");

        Scanner teclado = new Scanner(System.in);

        System.out.print("Ingresar dni del cliente: ");
        String dni = teclado.nextLine();

        clientes.removeIf(x -> x.getDni().equals(dni));
    }

    private static void consultarClienteDni() {

        System.out.println("====== Consulta cliente por dni ========");

        Scanner teclado = new Scanner(System.in);

        System.out.print("Ingresar dni del cliente: ");
        String dni = teclado.nextLine();

        Cliente cliente = clientes.stream().filter(x -> x.getDni().equals(dni)).findAny().orElse(null);

        if (cliente != null) {
            System.out.println(cliente);
        } else {
            System.out.println("No existe cliente con DNI " + dni);
        }
    }
}

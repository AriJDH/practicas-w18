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
            System.out.println("5) Crear factura");
            System.out.println("6) Salir");

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
                    crearFactura();
                    break;
                case 6:
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

        Cliente cliente = getCliente(dni);

        if (cliente != null) {
            System.out.println(cliente);
        } else {
            System.out.println("No existe cliente con DNI " + dni);
        }
    }

    private static Cliente getCliente(String dni) {
        return clientes.stream().filter(x -> x.getDni().equals(dni)).findAny().orElse(null);
    }

    private static void crearFactura() {

        System.out.println("======== Creacion factura ========");

        Scanner teclado = new Scanner(System.in);

        System.out.println("Ingresar dni cliente: ");
        String dniCliente = teclado.nextLine();

        Cliente cliente = getCliente(dniCliente);

        List<Item> items = crearItems();

        cliente.crearFacturas(items);
    }

    private static List<Item> crearItems() {

        List<Item> items = new ArrayList<>();

        Scanner teclado = new Scanner(System.in);

        while (true) {
            System.out.println("====== Creacion items ======");

            System.out.println("Ingresar codigo: ");
            String codigo = teclado.nextLine();

            System.out.println("Ingresar nombre: ");
            String nombre = teclado.nextLine();

            System.out.println("Ingresar cantidad comprada: ");
            Integer cantidadComprada = teclado.nextInt();

            System.out.println("Ingresar costo unitario: ");
            Double costoUnitario = teclado.nextDouble();

            Item item = new Item(codigo, nombre, cantidadComprada, costoUnitario);

            items.add(item);

            System.out.println("¿Terminar creacion items? ");
            boolean terminarCreacion = teclado.nextBoolean();

            if (terminarCreacion) {
                break;
            }
        }

        return items;
    }
}

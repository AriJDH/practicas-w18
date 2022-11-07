package clase4_a_EjerciciosIntegrador.Ej3_Supermercado;

import java.util.*;

public class Test {
    public  static Scanner teclado = new Scanner(System.in);
    public static void main(String[] args) {
        Set<Cliente> setClientes = new HashSet<>();
        List<Factura> listFacturas = new ArrayList<>();
        menuSupermercado( setClientes, listFacturas );
        teclado.close();
    }
    public static void menuSupermercado(Set<Cliente> setClientes, List<Factura> listFacturas){
        char opcion='0';
        do{
            System.out.println("--------------------------------------------------------------------");
            System.out.println("Supermercado - Ingrese su opción: ");
            System.out.println("--------------------------------------------------------------------");
            System.out.println("1 - Nuevo cliente");
            System.out.println("2 - Mostrar todos los cientes");
            System.out.println("3 - Eliminar cliente x DNI");
            System.out.println("4 - Mostrar cliente x DNI");
            System.out.println("5 - Nueva Factura");
            System.out.println("\n0 - Salir");
            System.out.println("--------------------------------------------------------------------");
            opcion = teclado.nextLine().charAt(0);
            switch (opcion){
                case '1': nuevoCliente(setClientes);
                    break;
                case '2': listarClientes(setClientes);
                    break;
                case '3': eliminarCliente(setClientes);
                    break;
                case '4': mostrarCliente(setClientes);
                    break;
                case '5': nuevaFactura(setClientes, listFacturas);
                    break;
                case '0': System.out.println("\nSaliendo...");
                    break;
            }
        }while (opcion != '0');
    }

    private static void nuevaFactura(Set<Cliente> setClientes, List<Factura> listFacturas) {
        System.out.println("--------------------------------------------------------------------");
        System.out.println("Nueva factura");
        System.out.println("--------------------------------------------------------------------");
        System.out.print("Ingrese el DNI del cliente: ");
        String dni = teclado.nextLine();
        Optional<Cliente> cliente = setClientes.stream().filter(c-> c.getDni().equals(dni)).findFirst();
        if (!cliente.isPresent()){
            System.out.println("Cliente con DNI " + dni + " no encontrado, se creará a continuación...");
            cliente = nuevoCliente(setClientes, dni);
        }
        List<Item> listaItems = new ArrayList<>();
        String codigo, nombre;
        int cantComprada;
        double precioUnitario;
        char opcion = 'N';
        do {
            System.out.println("--------------------------------------------------------------------");
            System.out.println("Producto");
            System.out.println("--------------------------------------------------------------------");
            System.out.print("Código: ");
            codigo = teclado.nextLine();
            System.out.print("Nombre: ");
            nombre = teclado.nextLine();
            System.out.print("Cantidad comprada: ");
            cantComprada = teclado.nextInt();
            teclado.nextLine();
            System.out.print("Precio Unitario: ");
            precioUnitario = teclado.nextDouble();
            teclado.nextLine();
            listaItems.add(new Item(codigo, nombre, cantComprada, precioUnitario));
            System.out.println("--------------------------------------------------------------------");
            System.out.print("Desea registrar otro producto a la factura? (S/N): ");
            opcion = teclado.nextLine().toUpperCase().charAt(0);
        } while(opcion == 'S');
        Factura factura = new Factura(cliente.get(), listaItems);
        listFacturas.add(factura);
        System.out.println("--------------------------------------------------------------------");
        System.out.println("El monto total de la factura es $" + factura.getTotalCompra());
        System.out.println("\nPresione una tecla para continuar...");
        teclado.nextLine();
    }

    public static void nuevoCliente(Set<Cliente> setClientes){
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
        setClientes.add(new Cliente(dni,nombre,apellido));
        System.out.println("\nPresione una tecla para continuar...");
        teclado.nextLine();
    }

    public static Optional<Cliente> nuevoCliente(Set<Cliente> setClientes, String dni){
        String nombre, apellido;
        System.out.println("--------------------------------------------------------------------");
        System.out.println("Nuevo cliente DNI: " + dni);
        System.out.println("--------------------------------------------------------------------");
        System.out.print("Nombre: ");
        nombre = teclado.nextLine();
        System.out.print("Apellido: ");
        apellido = teclado.nextLine();
        Optional<Cliente> cliente = Optional.of(new Cliente(dni, nombre, apellido));
        setClientes.add(cliente.get());
        System.out.println("\nPresione una tecla para continuar...");
        teclado.nextLine();
        return cliente;
    }


    public static void listarClientes(Set<Cliente> setClientes){
        System.out.println("--------------------------------------------------------------------");
        System.out.println("Listado de clientes");
        System.out.println("--------------------------------------------------------------------");
        setClientes.stream().forEach(System.out::println);
        System.out.println("\nPresione una tecla para continuar...");
        teclado.nextLine();
    }

    public static void eliminarCliente(Set<Cliente> setClientes){
        String dni;
        System.out.println("--------------------------------------------------------------------");
        System.out.printf("Ingrese un DNI para buscar el cliente a eliminar: ");
        dni = teclado.nextLine();
        System.out.println("--------------------------------------------------------------------");
        Optional<Cliente> cliente = setClientes.stream().filter(c-> c.getDni().equals(dni)).findFirst();
        if (cliente.isPresent()){
            setClientes.remove(cliente.get());
            listarClientes(setClientes);
        }else{
            System.out.println("No se encontró el cliente con DNI " + dni);
            System.out.println("\nPresione una tecla para continuar...");
            teclado.nextLine();
        }
    }

    public static void mostrarCliente(Set<Cliente> setClientes){
        String dni;
        System.out.println("--------------------------------------------------------------------");
        System.out.printf("Ingrese un DNI para buscar el cliente a mostrar: ");
        dni = teclado.nextLine();
        System.out.println("--------------------------------------------------------------------");
        Optional<Cliente> cliente = setClientes.stream().filter(c-> c.getDni().equals(dni)).findFirst();
        if (cliente.isPresent()){
            System.out.println(cliente.get());
        }else{
            System.out.println("No se encontró el cliente con DNI " + dni);
        }
        System.out.println("\nPresione una tecla para continuar...");
        teclado.nextLine();
    }


}

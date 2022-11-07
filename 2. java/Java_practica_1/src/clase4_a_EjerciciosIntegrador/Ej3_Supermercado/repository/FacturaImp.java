package clase4_a_EjerciciosIntegrador.Ej3_Supermercado.repository;

import clase4_a_EjerciciosIntegrador.Ej3_Supermercado.model.Cliente;
import clase4_a_EjerciciosIntegrador.Ej3_Supermercado.model.Factura;
import clase4_a_EjerciciosIntegrador.Ej3_Supermercado.model.Item;

import java.util.*;

public class FacturaImp implements CRUDRepository<Factura> {

    private Scanner teclado = new Scanner(System.in);
    List<Factura> listFacturas = new ArrayList<>();
    @Override
    public void nuevo(Factura factura) {

    }

    @Override
    public void mostrarTodos() {

    }

    @Override
    public void eliminar(Factura factura) {

    }

    @Override
    public void nuevoConMenu() {
        /*System.out.println("--------------------------------------------------------------------");
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

         */
    }
 /*
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


  */
    @Override
    public void mostrarUno() {

    }

    @Override
    public Optional<Factura> buscar(String s) {
        return Optional.empty();
    }
}

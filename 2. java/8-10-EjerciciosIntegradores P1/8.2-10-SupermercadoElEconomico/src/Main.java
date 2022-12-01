import model.Cliente;
import model.Factura;
import model.Item;
import repository.ClienteImpl;
import repository.FacturaImpl;
import repository.ItemImpl;

import java.util.Scanner;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {

        ClienteImpl clienteImpl = new ClienteImpl();
        FacturaImpl facturaImpl = new FacturaImpl();
        ItemImpl itemImpl = new ItemImpl();

        // --------------------- PARTE 1 --------------------- //
        System.out.println("============ Creamos clientes y los guardamos ============");
        Cliente cliente1 = new Cliente(12345L,
                "Nombre1",
                "Apellido1");
        Cliente cliente2 = new Cliente(23456L,
                "Nombre2",
                "Apellido2");
        Cliente cliente3 = new Cliente(56789L,
                "Nombre3",
                "Apellido3");


        // Guardamos los 3 clientes
        clienteImpl.guardar(cliente1);
        clienteImpl.guardar(cliente2);
        clienteImpl.guardar(cliente3);

        System.out.println("============ Mostramos todos los clientes ============");
        clienteImpl.mostrarTodos();

        System.out.println("============ Eliminamos un cliente  ============");
        clienteImpl.eliminarPorId(23456L);
        System.out.println("============ Mostramos todos los clientes ============");
        clienteImpl.mostrarTodos();

        // Solicitamos por consola el DNI:
        System.out.println("============ Buscamos un cliente por su dni ============");
        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese un DNI\n");
        Long dniIngresado = input.nextLong();
        clienteImpl.buscarPorId(dniIngresado);

        // --------------------- PARTE 2 --------------------- //
        // Para crear la factura necesitamos:
        Item item1 = new Item(
                1L,
                "Producto1",
                2,
                10.00
        );

        Item item2 = new Item(
                2L,
                "Producto2",
                2,
                10.00
        );

        System.out.println("============ Guardamos los items ============");
        itemImpl.guardar(item1);
        itemImpl.guardar(item2);

        // Creamos una factura
        Factura factura1 = new Factura(
                123L,
                cliente1,
                itemImpl.listarTodos(),
                10.00);

        Factura factura2 = new Factura(
                124L,
                cliente1,
                itemImpl.listarTodos(),
                10.00);


        System.out.println("============ Guardamos la factura / cliente existente ============");
        facturaImpl.guardar(factura1);


        System.out.println("============ Guardamos la factura / cliente inexistente ============");
        facturaImpl.guardar(factura2);

    }
}
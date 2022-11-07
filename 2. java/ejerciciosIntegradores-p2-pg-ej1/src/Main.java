import model.Cliente;
import model.Factura;
import model.Item;
import repository.ClienteRepository;
import repository.FacturaRepository;
import repository.ItemRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Parte I
        System.out.println("Welcome to Supermercado “El económico”!");

        // Crear clientes
        ClienteRepository clienteRepository = new ClienteRepository();
        Cliente cliente1 = new Cliente(2918371, "babab", "abababa");
        Cliente cliente2 = new Cliente(92834720, "uiiuiui", "iuiuiui");
        Cliente cliente3 = new Cliente(1947829, "ogogogog", "gogogogo");
        clienteRepository.create(cliente1);
        clienteRepository.create(cliente2);
        clienteRepository.create(cliente3);

        System.out.println("Lista de clientes inicial:");
        clienteRepository.printAll();

        System.out.println("Lista de clientes reducido:");
        clienteRepository.delete(92834720);
        clienteRepository.printAll();

        System.out.println("Busqueda - ingresar DNI:");
        int dni = new Scanner(System.in).nextInt();  // Read user input
        Optional<Cliente> clienteOptional = clienteRepository.retrieve(dni);
        if (clienteOptional.isPresent()) {
            System.out.println(clienteOptional.get());
        } else {
            System.out.println("Cliente no encontrado :'(");
        }

        Cliente cliente4 = new Cliente(28492834, "uwuwuwuwu", "wuwuwuwu");
        if (clienteRepository.update(1947829, cliente4)){
            System.out.println("Cliente " + cliente4.getDni() + " actualizado");
        } else {
            System.out.println("Error: cliente no encontrado");
        }
        System.out.println("Lista de clientes actualizado:");
        clienteRepository.printAll();

        // Parte II
        ItemRepository itemRepository = new ItemRepository();
        FacturaRepository facturaRepository = new FacturaRepository();

        Item item1 = new Item(11, "brie", 5, 4.95);
        Item item2 = new Item(12, "gouda", 2, 3.95);
        Item item3 = new Item(13, "parmesano", 8, 2.50);
        Item item4 = new Item(14, "cheddar", 1, 9.99);
        itemRepository.create(item1);
        itemRepository.create(item2);
        itemRepository.create(item3);
        itemRepository.create(item4);

        Cliente cliente5 = new Cliente(478484, "lelelelel", "elelelel");
        Factura factura1 = new Factura(123, cliente5, itemRepository.retrieveAll());

        if (clienteRepository.retrieve(factura1.getCliente().getDni()).isEmpty()) {
            clienteRepository.create(factura1.getCliente());
        }

        facturaRepository.create(factura1);
        System.out.println("Repositorio de facturas:");
        facturaRepository.printAll();

        System.out.println("Total de factura:");
        facturaRepository.retrieve(123).ifPresent(factura -> System.out.println(factura.getTotalCompra()));

    }
}
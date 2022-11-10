import model.Cliente;
import model.Factura;
import model.Item;
import repository.ClienteImp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        ClienteImp clientes = new ClienteImp();

        Cliente cli1 = new Cliente("3243243", "Axel", "Rodriguez");
        Cliente cli2 = new Cliente("3443534", "Julio", "Palombo");
        Cliente cli3 = new Cliente("4355455", "Martin", "Palermo");

        clientes.create(cli1);
        clientes.create(cli2);
        clientes.create(cli3);

        clientes.mostrarPorPantalla();

        // Get
        Scanner in = new Scanner(System.in);
        System.out.println("Ingrese dni: ");
        String dni = in.nextLine();

        System.out.println(clientes.getById(dni));

        // Delete
        clientes.delete("3243243");
        clientes.mostrarPorPantalla();
        System.out.println();
        clientes.delete("3443534");
        clientes.mostrarPorPantalla();
        System.out.println();
        clientes.delete("23423433");
        clientes.mostrarPorPantalla();
        System.out.println();

/*
        listaClientes.stream()
                .filter(c -> !c.getDni().equals("3243243"))
                .collect(Collectors.toList())
                .forEach(System.out::println);


        Scanner in = new Scanner(System.in);
        System.out.println("Ingrese dni: ");
        String dni = in.nextLine();

        boolean encontrado = false;

        for(Cliente c : listaClientes) {
            if (c.getDni().equals(dni)) {
                System.out.println(c);
                encontrado = true;
            }
        }

        if(!encontrado) {
            System.out.println("Dni no encontrado");
        }
*/
        // Parte 2
        Item item1 = new Item("32432", "Sibarita", 2, 900);
        Item item2 = new Item("42424", "Arroz", 2, 300);
        Item item3 = new Item("11112", "Fideos", 2, 350);
        List<Item> items = Stream.of(item1, item2, item3).collect(Collectors.toList());
        items.stream().forEach(System.out::println);

        Factura factura = new Factura("232323", cli1, items);
        System.out.println(factura.getTotal());
    }
}

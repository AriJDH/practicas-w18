package meli.bootcamp;

import meli.bootcamp.clases.Cliente;
import meli.bootcamp.clases.DetalleFactura;
import meli.bootcamp.clases.Factura;
import meli.bootcamp.clases.Item;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Ignacio Lobaiza
 */
public class App 
{
    public static void main( String[] args )
    {
        Scanner sc = new Scanner(System.in);
        ArrayList<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente("11.111.111","nombre 1","apellido 2"));
        clientes.add(new Cliente("11.111.121","nombre 2","apellido2"));
        clientes.add(new Cliente("11.111.131","nombre 3","apellido3"));
        System.out.println("DATOS DE LOS CLIENTES:");
        clientes.forEach(System.out::println);
        System.out.println("──────────────────────");
        System.out.print("INGRESE EL DNI DEL CLIENTE A ELIMINAR: ");
        String dniEliminar = sc.nextLine();
        eliminarCliente(dniEliminar, clientes);
        clientes.forEach(System.out::println);
        System.out.println("──────────────────────");
        System.out.print("INGRESE EL DNI DEL CLIENTE A BUSCAR: ");
        String dniBuscar = sc.nextLine();
        int indexBuscado = buscarCliente(dniBuscar, clientes);
        if (indexBuscado != -1)
        {
            System.out.println("CLIENTE ENCONTRADO!");
            System.out.println(clientes.get(indexBuscado));
        }
        else
        {
            System.out.println("CLIENTE NO ENCONTRADO");
        }
        System.out.println("──────────────────────");
        Factura factura = new Factura();
        Item item1 = new Item(1,"PRODUCTO 1", 200.5);
        Item item2 = new Item(2,"PRODUCTO 2", 50);
        Item item3 = new Item(3,"PRODUCTO 3", 150.5);
        DetalleFactura detalleFactura1 = new DetalleFactura(10, item1);
        DetalleFactura detalleFactura2 = new DetalleFactura(10, item2);
        DetalleFactura detalleFactura3 = new DetalleFactura(10, item3);

        ArrayList<DetalleFactura> detalleFacturas = new ArrayList<>();
        detalleFacturas.add(detalleFactura1);
        detalleFacturas.add(detalleFactura2);
        detalleFacturas.add(detalleFactura3);

        Cliente error = new Cliente("1","a","b");
        // clientes.add(error);
        factura.setCliente(error, clientes);
        factura.setDetalle(detalleFacturas);
        System.out.println("──────────────────────");
        System.out.println("PRECIO FINAL A PAGAR:");
        factura.setPrecio();
        System.out.println(factura.getPrecio());
    }

    private static void eliminarCliente(String dni, ArrayList<Cliente> clientes)
    {
        for (int i = 0; i < clientes.size(); i++)
        {
            if (dni.equals(clientes.get(i).getDni()))
            {
                clientes.remove(i);
                break;
            }
        }
    }

    private static int buscarCliente(String dni, ArrayList<Cliente> clientes)
    {
        int index = -1;
        for (int i = 0; i < clientes.size(); i++) {
            if (dni.equals(clientes.get(i).getDni()))
            {
                index = i;
                return index;
            }
        }
        return index;
    }
}

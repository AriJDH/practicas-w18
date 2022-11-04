package org.example;

import org.example.domain.Cliente;
import org.example.domain.Factura;
import org.example.domain.ItemCompra;
import org.example.services.ClienteRepositoryService;
import org.example.services.FacturaRepositoryService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    private static ClienteRepositoryService clienteRepositoryService = new ClienteRepositoryService();
    private static FacturaRepositoryService facturaRepositoryService = new FacturaRepositoryService();

    public static void crearCliente(){
        long cantClientes = clienteRepositoryService.count();
        clienteRepositoryService.add(new Cliente((int) cantClientes,  "Nombre "+ cantClientes, "Apellido" + cantClientes));
    }

    public static void mostrarClientes(){
        clienteRepositoryService.findAll().forEach(cli-> System.out.println(cli.toString()));
    }

    public static void crearNuevaFactura(){
        long cantClientes = clienteRepositoryService.count();
        Cliente cliente = new Cliente((int) cantClientes,  "Nombre "+ cantClientes, "Apellido" + cantClientes);
        List<ItemCompra> items = new ArrayList<>();
        items.add( new ItemCompra("11111", "yogurt",1+ (int)cantClientes, 100));
        items.add( new ItemCompra("11111", "milanesa",  1+ (int)cantClientes, 200));
        facturaRepositoryService.add(new Factura(cliente, items));
    }

    public static void mostrarFacturas(){
        facturaRepositoryService.findAll().forEach(f-> System.out.println(f.toString()));
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        while(true){
            System.out.println("------------------------------");
            System.out.println("Ingrese la opción: ");
            System.out.println("1-Crear cliente");
            System.out.println("2-Mostrar clientes");
            System.out.println("3-Crear factura");
            System.out.println("4-Mostrar facturas");
            int op = teclado.nextInt();
            teclado.nextLine();
            switch (op){
                case 1:
                    crearCliente();
                    break;
                case 2:
                    mostrarClientes();
                    break;
                case 3:
                    crearNuevaFactura();
                    break;
                default:
                    mostrarFacturas();
                    break;
            }
            System.out.println("------------------------------");
        }


    }
}
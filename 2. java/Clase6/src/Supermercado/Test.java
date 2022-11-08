package Supermercado;
import Supermercado.Repositorio.RepoCliente;
import Supermercado.Repositorio.RepoFacturas;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
    private static RepoCliente repoCliente1 = new RepoCliente();
    private static RepoFacturas repoFacturas = new RepoFacturas();

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int opcion;

        do{
            System.out.println("Eliga una opcion: ");
            System.out.println("1- Generar un cliente");
            System.out.println("2- Ver lista de clientes");
            System.out.println("3- Eliminar un cliente");
            System.out.println("4- Generar una factura");
            System.out.println("5- Ver lista de facturas");
            System.out.println("6- Cargar repo cliente");
            opcion = teclado.nextInt();

            switch (opcion){
                case 1: {
                    generarUnCliente(cargarNuevoCliente());
                    break;
                }
                case 2: {
                    verListaDeClientes();
                    break;
                }
                case 3: {
                    System.out.println("Ingrese el id del cliente que desea eliminar");
                    Long idCliente = teclado.nextLong();
                    eliminarUnCliente(idCliente);
                }
                case 4: {
                    generarUnaFactura();
                }
                case 5: {
                    verListaDeFacturas();
                }
            }
        }while(opcion!=0);

        /*Cliente cliente1 = new Cliente(344556L, "Carlos", "Martinez");
        Cliente cliente2 = new Cliente(765533L, "Izumi", "Fabiano");
        Cliente cliente3 = new Cliente(3445453L, "Taro", "Fabiano");

        repoCliente1.create(cliente1);
        repoCliente1.create(cliente2);
        repoCliente1.create(cliente3);

        repoCliente1.getListaClientes().stream().forEach(h-> System.out.println(h.toString()));

        repoCliente1.delete(cliente1.getId());
        System.out.println("______________________________________________________________________");
        repoCliente1.getListaClientes().stream().forEach(h-> System.out.println(h.toString()));

        //solicitarDniCliente();

        Item item1 = new Item(12, "Arroz", 300, 2);
        Item item2 = new Item(10, "Harina", 400, 2);

        Cliente cliente4 = new Cliente(928283L, "Kurt", "Fabiano");
        Factura factura1 = new Factura(cliente4, Arrays.asList(item1, item2));
        repoFacturas.create(factura1);
        repoCliente1.create(cliente4);
        System.out.println("______________________________________________________________________");
        repoFacturas.getListaFacturas().stream().forEach(h-> System.out.println(h.toString()));*/

    }

    public static Cliente cargarNuevoCliente(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese el dni: ");
        long dni = teclado.nextInt();
        System.out.println("Ingrese el nombre: ");
        String nombre = teclado.next();
        System.out.println("Ingrese el apellido: ");
        String apellido = teclado.next();

        Cliente nuevoCliente = new Cliente(dni, nombre, apellido);
        return nuevoCliente;
    }

    public static void generarUnCliente(Cliente nuevoCliente){
        repoCliente1.create(nuevoCliente);
    }

    public static Cliente clienteExistente(){
        System.out.println("Ingrese el DNI del cliente");
        Scanner teclado = new Scanner(System.in);
        int dni = teclado.nextInt();

        for(Cliente cli: repoCliente1.getListaClientes()){
            if(cli.getDni() == dni){
                System.out.println(cli.toString());
                return cli;
            }
        }
        System.out.println("No se encontro un cliente con ese DNI");
        return null;
    }

    public static void verListaDeClientes(){
        repoCliente1.getListaClientes().stream().forEach(h-> System.out.println(h.toString()));
    }

    public static void eliminarUnCliente(Long IdCliente){
        repoCliente1.delete(IdCliente);
        System.out.println("El cliente ha sido eliminado");
    }

    public static void generarUnaFactura(){
        Cliente cliente = clienteExistente();
        if(cliente == null){
            cliente = cargarNuevoCliente();
        }
        Factura nuevaFactura = new Factura(cliente,cargarListaDeItems());
    }

    public static List<Item> cargarListaDeItems(){
        List<Item> listaDeItems = new ArrayList<>();
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese cuantos items desea cargar: ");
        long cantidad = teclado.nextInt();

        for(int i=0; i<cantidad; i++){
            System.out.println("Ingrese el codigo de item: ");
            Long codigo = teclado.nextLong();
            System.out.println("Ingrese el nombre del producto: ");
            String nombre = teclado.next();
            System.out.println("Ingrese el precio del producto: ");
            double precio = teclado.nextDouble();
            System.out.println("Ingrese la cantidad: ");
            int cantidadProductos = teclado.nextInt();

            Item nuevoItem = new Item(codigo, nombre, precio, cantidadProductos);
            listaDeItems.add(nuevoItem);
        }
        return listaDeItems;
    }

    public static void verListaDeFacturas(){
        repoFacturas.getListaFacturas().stream().forEach(h-> System.out.println(h.toString()));
    }

}



package com.meli.lgutierrez.clase4.tarde.ejercicioIntegrador;

import com.meli.lgutierrez.clase4.tarde.ejercicioIntegrador.model.Cliente;
import com.meli.lgutierrez.clase4.tarde.ejercicioIntegrador.model.Factura;
import com.meli.lgutierrez.clase4.tarde.ejercicioIntegrador.model.Item;
import com.meli.lgutierrez.clase4.tarde.ejercicioIntegrador.repository.ClienteImp;
import com.meli.lgutierrez.clase4.tarde.ejercicioIntegrador.repository.FacturaImp;
import com.meli.lgutierrez.clase4.tarde.ejercicioIntegrador.repository.ItemImp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ClienteImp rpCliente = new ClienteImp();
        ItemImp rpItem = new ItemImp();
        FacturaImp rpFactura = new FacturaImp();

        Scanner tecladoInteger = new Scanner(System.in);
        Scanner tecladoString = new Scanner(System.in);
        Integer codigoFactura = 1234;

        //-----------------------------------Primer Spring-------------------------------------


        Cliente cliente1 = new Cliente(123, "Laura", "Gutierrez");
        Cliente cliente2 = new Cliente(456, "Jhon", "Betancourt");
        Cliente cliente3 = new Cliente(789, "Celeste", "BG");

        rpCliente.agregar(cliente1);
        rpCliente.agregar(cliente2);
        rpCliente.agregar(cliente3);

        /*System.out.println("\nNuestros clientes son:");
        rpCliente.mostrar();

        System.out.println("\nEscriba el DNI del cliente que desea eliminar: ");
        Integer dni = tecladoInteger.nextInt();
        rpCliente.eliminar(dni);

        System.out.println("\nNuestros clientes son:");
        rpCliente.mostrar();

        System.out.println("\nBuscar cliente:");
        System.out.println("Escriba el DNI del cliente que desea buscar: ");
        dni = tecladoInteger.nextInt();
        Optional<Cliente> respuesta = rpCliente.buscar(dni);

        if (respuesta.isEmpty()){
            System.out.println("Lo lamento el cliente no se encuentra en la base de datos.");
        }else {
            System.out.println("El cliente buscado es: " + respuesta.get());
        }
        //tecladoInteger.close();
        //tecladoString.close();
        */

        //-----------------------------------Segundo Spring-------------------------------------
        System.out.println("\nIngrese el dni del cliente para crear una factura:");
        Integer dni = tecladoInteger.nextInt();

        Optional<Cliente> respCliente = rpCliente.buscar(dni);

        while (respCliente.isEmpty()){
            System.out.println("No se ha encontrado un cliente con ese dni. Por favor ingrese el nombre para crearlo en la base de datos:");
            String nombre = tecladoString.nextLine();
            System.out.println("Por favor ingrese el apellido: ");
            String apellido = tecladoString.nextLine();
            Cliente cliente = new Cliente(dni, nombre, apellido);
            rpCliente.agregar(cliente);
            respCliente = rpCliente.buscar(dni);
        }

        //Lista de items en venta
        Item tomate = new Item(4544, "tomate", 1, 800D);
        Item lechuga = new Item(4569, "lechuga", 1, 2200D);
        Item apio = new Item(4587, "apio", 1, 1200D);
        Item manzana = new Item(4698, "manzana", 1, 1700D);

        List<Item> itemsVenta = new ArrayList<>();
        itemsVenta.add(tomate);
        itemsVenta.add(lechuga);
        itemsVenta.add(apio);
        itemsVenta.add(manzana);

        boolean bandera = true;
        while (bandera){
            //Listar productos en venta
            System.out.println("\n-------Lista de productos a la venta-------");
            for (int i = 0; i < itemsVenta.size(); i++) {
                System.out.println(i+1 + ". " + itemsVenta.get(i).getNombre() + ". Valor unidad: " + itemsVenta.get(i).getCostoUnitario());
            }
            //Escogiendo productos
            System.out.println("\nElija el producto que desea comprar: (solo ingrese el número)");
            Integer id = tecladoInteger.nextInt();
            Item producto = itemsVenta.get(id - 1);
            System.out.println("\nCuántas unidades desea comprar de este producto: (solo ingrese el número)");
            Integer cantidad = tecladoInteger.nextInt();

            //Agregando item al carrito
            rpItem.agregar(new Item(producto.getCodigo(), producto.getNombre(), cantidad, producto.getCostoUnitario()));

            //Verificando más compras
            System.out.println("\nDesea comprar más productos? (Si/No)");
            String resp = tecladoString.nextLine();

            if (resp.toLowerCase().equals("no")){
                bandera = false;
            }
        }
        tecladoInteger.close();
        tecladoString.close();

        //Creando factura
        Factura factura = new Factura(codigoFactura++, respCliente.get(), rpItem.getItems(), rpFactura.calcularValorTotal(rpItem.getItems()));
        System.out.println(factura);
    }
}

package clase3.supermercado;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ArrayList<Cliente> clientes;
        ArrayList<Factura> facturas;
        ArrayList<Producto> productos;

        clientes = new ArrayList<>();
        facturas = new ArrayList<>();
        productos = new ArrayList<>();

        //crear productos
        Producto p1 = new Producto(1, "Coca Cola", 10, 100);
        Producto p2 = new Producto(2, "Pepsi", 10, 100);
        Producto p3 = new Producto(3, "Fanta", 10, 100);
        Producto p4 = new Producto(4, "Sprite", 10, 100);
        Producto p5 = new Producto(5, "Manaos", 10, 100);
        Producto p6 = new Producto(6, "Cerveza", 10, 100);
        Producto p7 = new Producto(7, "Agua", 10, 100);
        Producto p8 = new Producto(8, "Galletitas", 10, 100);

        //agregar productos a la lista
        productos.add(p1);
        productos.add(p2);
        productos.add(p3);
        productos.add(p4);
        productos.add(p5);
        productos.add(p6);
        productos.add(p7);
        productos.add(p8);

        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        // menu





        boolean salir = false;
        while(!salir){
            System.out.println("Bienvenido al supermercado");
            System.out.println("1. Agregar cliente");
            System.out.println("2. Agregar factura");
            System.out.println("3. Listar clientes");
            System.out.println("4. Eliminar cliente");
            System.out.println("5. Buscar cliente");
            System.out.println("6. Salir");
            System.out.println("Ingrese una opcion: ");
            opcion = scanner.nextInt();
        switch (opcion) {

            case 1:
                // crear cliente
                //scanner.close();
                agregar(clientes);
                break;
            case 2:
                // crear factura
                crearFactura(facturas, clientes, productos);
                break;

            case 3:
                // listar clientes
                listar(clientes);
                break;
            case 4:
                // eliminar clientes
                borrar(clientes);
                break;
            case 5:
                // buscar cliente
                buscar(clientes);
                break;
            case 6:
                // salir
                System.out.println("Gracias por su visita");
                salir = true;
                break;
        }
        }



    }

    static void borrar(ArrayList<Cliente> clientes) {

        System.out.println("Ingresar el dni de un cliente para borrarlo: ");
        Scanner teclado = new Scanner(System.in);
        int dni = teclado.nextInt();
        Cliente clienteBuscado = null;
        for (Cliente cliente : clientes) {
            if (cliente.getDni() == dni) {
                clienteBuscado = cliente;
            }
        }
        //teclado.close();
        if (clienteBuscado != null) {
            clientes.remove(clienteBuscado);
            System.out.println("El cliente buscado fue borrado");
        } else {
            System.out.println("No se encontro el cliente");
        }
    }

    static void buscar(ArrayList<Cliente> clientes){

        System.out.println("Ingresar el dni de un cliente para buscarlo: ");

        Scanner teclado = new Scanner(System.in);
        int dni = teclado.nextInt();
        Cliente clienteBuscado = null;
        for (Cliente cliente : clientes) {
            if (cliente.getDni() == dni) {
                clienteBuscado = cliente;
            }
        }
        //teclado.close();
        if (clienteBuscado != null) {
            System.out.println("El cliente buscado es: " + clienteBuscado);
        } else {
            System.out.println("No se encontro el cliente");
        }
    }

    static void listar(ArrayList<Cliente> clientes){

        System.out.println("Listado de clientes: ");
        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }
    }


    static void agregar(ArrayList<Cliente> clientes){

        System.out.println("Ingresar el nombre del cliente: ");
        Scanner teclado2 = new Scanner(System.in);
        String nombre = teclado2.nextLine();
        System.out.println("Ingresar el apellido del cliente: ");
        String apellido = teclado2.nextLine();
        System.out.println("Ingresar el dni del cliente: ");
        int dni = teclado2.nextInt();

        Cliente cliente = new Cliente(nombre, apellido, dni);
        clientes.add(cliente);
        System.out.println("El cliente fue agregado");
        //teclado2.close();
    }


    // void crear factura
    static void crearFactura(ArrayList<Factura> facturas, ArrayList<Cliente> clientes, ArrayList<Producto> productos) {

        System.out.println("Ingresar el dni del cliente: ");
        Scanner teclado = new Scanner(System.in);
        int dni = teclado.nextInt();
        Cliente clienteBuscado = null;
        for (Cliente cliente : clientes) {
            if (cliente.getDni() == dni) {
                clienteBuscado = cliente;
            }
        }
        //teclado.close();
        if (clienteBuscado != null) {

            //seleccionar  todos los productos que desee
            System.out.println("Seleccionar productos: ");
            System.out.println("ingrese x para salir");
            for (Producto producto : productos) {
                System.out.println(producto);
            }
            String opcion = "";
            ArrayList<Producto> productosSeleccionados = new ArrayList<>();
            while (!opcion.equals("x")) {
                System.out.println("ingrese el codigo del producto: ");
                opcion = teclado.nextLine();
                for (Producto producto : productos) {
                    // aca habria que hacer catch de una posible excepcion al convertir str a int
                    if (producto.getCodigo() == Integer.parseInt(opcion)) {
                        productosSeleccionados.add(producto);
                    }
                }
            }

            Factura factura = new Factura(clienteBuscado, productosSeleccionados);
            facturas.add(factura);
            System.out.println("La factura fue creada");
        } else {
            System.out.println("No se encontro el cliente");
        }
    }




}

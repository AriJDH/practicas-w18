package Main;

import Clases.Cliente;
import Clases.Factura;
import Clases.Producto;
import Repositorio.ClienteImp;
import Repositorio.FacturaImp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //Guardar clientes en la lista
        Cliente cliente1=new Cliente(111,"Maria","Duque");
        Cliente cliente2=new Cliente(222,"Esteban","Monsalve");
        Cliente cliente3=new Cliente(333,"Paula","Duque");

        ClienteImp clienteImp = new ClienteImp(); //Creo una instancia de la implementación. Ella ya me trae la lista
        clienteImp.guardar(cliente1);
        clienteImp.guardar(cliente2);
        clienteImp.guardar(cliente3);

        //Recorrer lista de clientes
        clienteImp.imprimir();

        //Info del que soliciten
        System.out.println("Ingrese el dni del cliente que desea consultar: ");
        Scanner texto = new Scanner(System.in);
        int dni = texto.nextInt();

        clienteImp.buscar(dni);


        //Borrar cliente que pidan
        System.out.println("Ingrese el dni del cliente que desea borrar: ");
        int dni2 = texto.nextInt();

        clienteImp.eliminar(dni2);


        //Crear nueva factura
        FacturaImp facturaImp = new FacturaImp();

        System.out.println("Ingrese el dni de la persona a la que se le va a asignar la factura");
        int dni3 = texto.nextInt();
        boolean bandera3 =false;
        Cliente clienteFactura = new Cliente();

        //Cliente para la factura
        for(Cliente cliente: clienteImp.traerTodos()) {
            if (cliente.getDni()==dni3) {
                bandera3=true;
                clienteFactura=cliente;
                System.out.println("El cliente si está creado");

            }
        }
        if (!bandera3){
            System.out.println("El cliente no esta creado, ingrese sus datos (dni, nombre, apellido");
            Cliente clienteFactura2=new Cliente(texto.nextInt(),texto.next(),texto.next());
            clienteImp.traerTodos().add(clienteFactura2);
            clienteFactura=clienteFactura2;
        }

        //Productos para la factura
        List<Producto> listaProductos1 = new ArrayList<Producto>();
        System.out.println("Ingrese los productos adquiridos por el cliente y su información");
        System.out.println("Cuantos productos adquirió?");
        int numeroProductos = texto.nextInt();

        for(int i=0; i<numeroProductos;i++){
            System.out.println("Ingrese codigo, nombre, cantidad y costo del producto, separados por un espacio");
            Producto producto = new Producto(texto.nextInt(),texto.next(),texto.nextInt(),texto.nextInt());
            listaProductos1.add(producto);
        }

        //Total para la factura
        int total=0;
        for(Producto producto: listaProductos1) {
            total+=producto.getCostoUnitario()* producto.getCantidadComprada();
        }

        //Agregartodo a la factura
        facturaImp.traerTodos().add(new Factura(clienteFactura,listaProductos1,total));

        for(Factura factura:facturaImp.traerTodos()){
            System.out.println(factura.getCliente().getNombre());
            System.out.println(factura.getListaProductos().toString());
            System.out.println(factura.getTotal());
        }

    }
}
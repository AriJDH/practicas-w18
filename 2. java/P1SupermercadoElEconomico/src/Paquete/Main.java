package Paquete;

import Clases.Cliente;
import Clases.Factura;
import Clases.Producto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	//Lista de clientes
        List<Cliente> listaClientes = new ArrayList<Cliente>();

        listaClientes.add(new Cliente(111,"Maria","Duque"));
        listaClientes.add(new Cliente(222,"Esteban","Monsalve"));
        listaClientes.add(new Cliente(333,"Paula","Duque"));

    //Recorrer lista de clientes
        for(Cliente cliente: listaClientes) {
            System.out.println(cliente.toString());
        }

    //Info del que soliciten
        System.out.println("Ingrese el dni del cliente que desea consultar: ");
        Scanner texto = new Scanner(System.in);
        int dni = texto.nextInt();
        boolean bandera =false;

        for(Cliente cliente: listaClientes) {
            if (cliente.getDni()==dni) {
                System.out.println(cliente.toString());
                bandera=true;
            }
        }

        if (bandera==false) {
            System.out.println("No se encuentra ningun cliente asociado a este Dni");
        }

        //Borrar cliente que pidan
        System.out.println("Ingrese el dni del cliente que desea borrar: ");
        int dni2 = texto.nextInt();
        boolean bandera2 =false;

        for(Cliente cliente: listaClientes) {
            if (cliente.getDni()==dni2) {
                listaClientes.remove(cliente);
                bandera2=true;
                System.out.println("Cliente eliminado");
            }
        }

        if (!bandera2) {
            System.out.println("No se encuentra ningun cliente asociado a este Dni");
        }

    }
}

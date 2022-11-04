package meli.bootcamp;

import meli.bootcamp.clases.Cliente;

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
        buscarCliente(dniBuscar, clientes);
        System.out.println("──────────────────────");

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

    private static void buscarCliente(String dni, ArrayList<Cliente> clientes)
    {
        boolean encontrado = false;
        for (Cliente c:
             clientes)
        {
            if (dni.equals(c.getDni()))
            {
                System.out.println(c);
                encontrado = true;
                break;
            }
        }
        if (!encontrado)
            System.out.println("NO SE ENCONTRO EL CLIENTE");
    }
}

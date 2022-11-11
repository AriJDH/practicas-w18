package supermercado;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sistema {

    public static void main(String[] args){

        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente("444444444","Jose","Perez"));
        clientes.add(new Cliente("55555555","Juan", "Gonzalez"));
        clientes.add(new Cliente("66666666", "Martin", "Fernandez"));

        Supermercado supermercado = new Supermercado("El económico",clientes);
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.println("--------------------------------Supermercado "+supermercado.getNombre()+"----------------------------------");
        System.out.println("-------------------------------------Clientes-----------------------------------------------");
        supermercado.mostrarClientes();
        System.out.println("---------------------------------Elimino cliente--------------------------------------------");
        supermercado.eliminarRegistroCliente();
        supermercado.mostrarClientes();

        Scanner scanner= new Scanner(System.in);
        System.out.println("--------------------------------Consulta de cliente-----------------------------------------");
        System.out.println("Ingrese DNI de cliente a consultar: ");
        String dniClienteABuscar = scanner.next();
        supermercado.consultarDatosCliente(dniClienteABuscar);

    }
}

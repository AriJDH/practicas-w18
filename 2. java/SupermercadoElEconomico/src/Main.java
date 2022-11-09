import model.Cliente;
import repository.ClienteImplementacion;
import repository.FacturaImplementacion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ClienteImplementacion clienteImplementacion = new ClienteImplementacion();
        FacturaImplementacion facturaImplementacion = new FacturaImplementacion();

        // creamos los clientes
        Cliente cliente1 = new Cliente(34256729L,"Martin","Perez");
        Cliente cliente2 = new Cliente(12121313L,"Daiana", "Camargo");
        Cliente cliente3 = new Cliente(13131212L,"Pedro", "Perez");

        // nuevos metodos implementados
        clienteImplementacion.save(cliente1);
        clienteImplementacion.mostrarPantalla();

        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese el dni a buscar");
        Long dniBuscado = teclado.nextLong();
        clienteImplementacion.buscar(dniBuscado);

        System.out.println("Ingrese el dni para elminar");
        Long dniBorrado = teclado.nextLong();
        clienteImplementacion.eliminar(dniBorrado);


        // agregamos los clientes a una lista
        /* List<Cliente> listaClientes= new ArrayList<Cliente>();
        listaClientes.add(cliente1);
        listaClientes.add(cliente2);
        listaClientes.add(cliente3); */

        // mostramos todos los clientes
        /*for (Cliente c : listaClientes) {
            System.out.println("Dni " + c.getDni());
            System.out.println("Nombre " + c.getNombre());
            System.out.println("Apellido " + c.getApellido());
        } */

        //borramos cliente por teclado
        /* Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese el dni de la persona a borrar");
        Long dniBorrado = teclado.nextLong();

        boolean bandera = false;
        for (Cliente c : listaClientes){
            if (c.getDni().equals(dniBorrado)){
                listaClientes.remove(c);
                bandera = true;
                break;
            }
        }
        if (!bandera) {
            System.out.println("No se encontro cliente a borrar");
        }else {
            System.out.println("Cliente borrado correctamente");
        } */


        //buscamos cliente por dni
        /* bandera = false;
        System.out.println("Ingrese dni a buscar");
        Long dniBuscado = teclado.nextLong();
        for (Cliente c : listaClientes) {
            if (c.getDni().equals(dniBuscado)){
                System.out.println("Cliente encontrado : ");
                System.out.println("Dni " + c.getDni());
                System.out.println("Nombre " + c.getNombre());
                System.out.println("Apellido " + c.getApellido());
                break;
            }

        }
        if (!bandera) {
            System.out.println("Cliente no encontrado");
        } */

    }
}

import model.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Cliente cliente1 = new Cliente(34256729L,"Martin","Perez");
        Cliente cliente2 = new Cliente(12121313L,"Daiana", "Camargo");
        Cliente cliente3 = new Cliente(13131212L,"Pedro", "Perez");

        List<Cliente> listaClientes= new ArrayList<Cliente>();
        listaClientes.add(cliente1);
        listaClientes.add(cliente2);
        listaClientes.add(cliente3);

        for (Cliente c : listaClientes) {
            System.out.println("Dni " + c.getDni());
            System.out.println("Nombre " + c.getNombre());
            System.out.println("Apellido " + c.getApellido());
        }

        Scanner teclado = new Scanner(System.in);
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
        }
        bandera = false;
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
        }




    }
}

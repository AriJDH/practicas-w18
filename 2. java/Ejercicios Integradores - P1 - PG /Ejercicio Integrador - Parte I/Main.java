import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        //Creacion de 3 objetos de la clase Cliente
        Cliente c1 = new Cliente("Juan", "Perez", "38.331.451");
        Cliente c2 = new Cliente("Pedro", "Alvarez", "35.678.531");
        Cliente c3 = new Cliente("Eloy", "Simonin", "42.891.394");

        //Se crea una collection ArrayList y se almacenan los clientes creados.
        List<Cliente> clientes = new ArrayList<Cliente>();

        clientes.add(c1);
        clientes.add(c2);
        clientes.add(c3);

        //Recorro la collection y muestro por pantalla los datos de cada cliente:
        System.out.println("Los datos personales de los clientes son: " + "\n");
        for(int i=0; i<clientes.size(); i++){
            System.out.println(clientes.get(i));
        }

        //Se elimina un cliente de la lista y se muestran nuevamente los datos de los clientes que quedaron

        boolean encontrado = false;
        System.out.println("Introduzca el numero de D.N.I que desea eliminar (incluya los puntos): ");
        String dniBorrado = entrada.nextLine();
        for(int i=0; i<clientes.size(); i++){
            if(clientes.get(i).getDni().equals(dniBorrado)){
                encontrado = true;
                clientes.remove(clientes.get(i));
                break;
            }
        }

        if(encontrado) {
            System.out.println("El cliente se elimino correctamente.");
            System.out.println("Los datos de los clientes restantes son: ");
            for(int i = 0; i<clientes.size(); i++){
                System.out.println(clientes.get(i));
            }
        } else {
            System.out.println("No se encontro el cliente a borrar");
        }




        //Se solicita por teclado el numero de DNI del cliente, en caso de encontrarlo mostrar su datos, caso contrario
        //informar dicha situación con algun mensaje de error.

        System.out.println("Por favor introduzca el numero de D.N.I que desea buscar (incluya los puntos): ");
        String dniBuscado = entrada.nextLine();

        encontrado = false;
        for(int i=0; i<clientes.size(); i++) {
            if(clientes.get(i).getDni().equals(dniBuscado)) {
                System.out.println("Cliente encontrado, sus datos son: ");
                System.out.println(clientes.get(i));
                encontrado = true;
                break;
            }
        }

        if(!encontrado) {
            System.out.println("ERROR! El número del dni no coincide con ninguno de los clientes registrados.");
        }




    }
}

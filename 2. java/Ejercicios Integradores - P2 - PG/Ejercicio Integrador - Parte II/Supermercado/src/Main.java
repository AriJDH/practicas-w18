import Model.Cliente;
import Repository.ClienteImp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ClienteImp cliImp = new ClienteImp();
        Scanner entrada = new Scanner(System.in);


        //Creacion de 3 objetos de la clase Cliente
        Cliente c1 = new Cliente("Juan", "Perez", "38.331.451");
        Cliente c2 = new Cliente("Pedro", "Alvarez", "35.678.531");
        Cliente c3 = new Cliente("Eloy", "Simonin", "42.891.394");

        //Guardar un cliente
        cliImp.save(c1);

        //Muestro por pantalla todos los clientes
        cliImp.mostrarPantalla();


        //Busqueda de un cliente
        System.out.println("Por favor introduzca el numero de D.N.I que desea buscar (incluya los puntos): ");
        String dniBuscado = entrada.nextLine();
        cliImp.buscar(dniBuscado);

        //Eliminación de un cliente
        System.out.println("Por favor introduzca el numero de D.N.I que desea eliminar (incluya los puntos): ");
        String dniBorrado = entrada.nextLine();
        cliImp.eliminar(dniBorrado);





        //Se elimina un cliente de la lista y se muestran nuevamente los datos de los clientes que quedaron





        //Se solicita por teclado el numero de DNI del cliente, en caso de encontrarlo mostrar su datos, caso contrario
        //informar dicha situación con algun mensaje de error.






    }
}
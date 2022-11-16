import Models.Cliente;
import Repository.ClienteImp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        ClienteImp cliImp = new ClienteImp();

        // Creamos 3 clientes
        Cliente cli1 = new Cliente(1234564789L,"cliente1","De paula");
        Cliente cli3 = new Cliente(2435345656L,"Zlatan","Ibraimovich");
        Cliente cli4 = new Cliente(865433234L,"mayra1","torres");

        cliImp.save(cli1); // gguardar el cliente

        cliImp.mostrarPantalla(); // mostrando los clientes

        // Buscado
        System.out.println("Ingrese el dni a buscar");
        Long dniBuscado = teclado.nextLong();
        cliImp.buscar(dniBuscado);

        //Borrado
        System.out.println("Ingrese el dni de la persona a borrar");
        Long dniBorrado = teclado.nextLong();
        cliImp.eliminar(dniBorrado);



    }
}
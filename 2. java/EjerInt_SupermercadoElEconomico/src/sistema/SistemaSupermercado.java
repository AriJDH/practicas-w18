package sistema;

import clases.Cliente;
import repositorios.RepositorioCliente;

import java.io.Console;
import java.util.Scanner;

public class SistemaSupermercado {
    private RepositorioCliente repoClientes;

    public SistemaSupermercado() {
        this.repoClientes = new RepositorioCliente();
    }

    public void ejecutarParte1(){
        this.repoClientes.preCargaClientes();
        this.repoClientes.verTodoslosClientes();

        System.out.println("\n***** SE INTENTA DAR DE BAJA EL CLIENTE CON DNI 2222222 *****");
        System.out.println(this.repoClientes.baja("2222222")+"\n");
        this.repoClientes.verTodoslosClientes();

        consultarClienteConDNI();


    }

    public void consultarClienteConDNI(){
        System.out.println("\n***** CONSULTA DE CLIENTE POR DNI *****");

        Scanner scanner = new Scanner(System.in);
        String loopUserInput = "";
        String dniInput = "";

        do{
            System.out.println("Ingrese DNI a consultar: ");
            dniInput = scanner.nextLine();

            Cliente cli = repoClientes.conuslta(dniInput);
            System.out.println(cli != null? cli.toString() :"No se encontró ningún cliente con el DNI "+dniInput);

            System.out.println("\nIngrese 1 para consultar otro cliente, cualquier otro valor para salir: ");
            loopUserInput = scanner.nextLine();
        }while(loopUserInput.equals("1"));

        scanner.close();
    }
}

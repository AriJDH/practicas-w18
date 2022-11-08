package sistema;

import clases.Cliente;
import clases.Factura;
import clases.Linea;
import clases.Producto;
import repositorios.RepositorioCliente;
import repositorios.RepositorioFactura;

import java.io.Console;
import java.util.ArrayList;
import java.util.Scanner;

public class SistemaSupermercado {
    private RepositorioCliente repoClientes;
    private RepositorioFactura repoFacturas;

    public SistemaSupermercado() {
        this.repoClientes = new RepositorioCliente();
        this.repoFacturas = new RepositorioFactura();
    }

    public void ejecutarParte1(){
        System.out.println("---------- PARTE 1 ----------");
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

    public void ejecutarParte2(){
        System.out.println("\n---------- PARTE 2 ----------");

        Producto p1 = new Producto("Pan", 50);
        Producto p2 = new Producto("Leche", 30);
        Producto p3 = new Producto("Arroz", 60);

        ArrayList<Linea> detalle1 = new ArrayList<Linea>();
        detalle1.add(new Linea(p3, 5));

        ArrayList<Linea> detalle2 = new ArrayList<Linea>();
        detalle2.add(new Linea(p3, 1));
        detalle2.add(new Linea(p2, 1));
        detalle2.add(new Linea(p1, 2));

        Cliente clienteExistente = this.repoClientes.conuslta("1111111");
        Cliente clienteNuevo = new Cliente("1212123", "Flamante", "Cliente");

        nuevaFactura(clienteExistente, detalle1);
        nuevaFactura(clienteNuevo, detalle2);
    }

    public void nuevaFactura(Cliente clienteParam, ArrayList<Linea> detalle){
        Cliente clienteSistema = null;
        if(clienteParam !=null)clienteSistema = this.repoClientes.conuslta(clienteParam.getDni());
        if(clienteSistema == null){
            this.repoClientes.alta(clienteParam);
            clienteSistema = clienteParam;
        }
        Factura nuevaFactura = new Factura(clienteSistema, detalle);
        System.out.println(this.repoFacturas.alta(nuevaFactura));
    }
}

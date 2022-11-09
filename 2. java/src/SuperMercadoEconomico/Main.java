package SuperMercadoEconomico;

import SuperMercadoEconomico.Clases.Cliente;
import SuperMercadoEconomico.Clases.Factura;
import SuperMercadoEconomico.Clases.Item;
import SuperMercadoEconomico.Repository.ClienteCrud;
import SuperMercadoEconomico.Repository.FacturaCrud;
import SuperMercadoEconomico.Repository.ItemCrud;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        /*List<Cliente> listaClientes = new ArrayList<>();
        Cliente cliente1 = new Cliente("1024", "Zlatan", "Rengifo");
        Cliente cliente2 = new Cliente("1025", "Patry", "Molina");
        Cliente cliente3 = new Cliente("1025", "Ana", "Valencia");

        listaClientes.add(cliente1);
        listaClientes.add(cliente2);
        listaClientes.add(cliente3);

        Stream.of(listaClientes).forEach(System.out::println);

        listaClientes.remove(2);
        Stream.of(listaClientes).forEach(System.out::println);

        Scanner scanner = new Scanner(System.in);

        System.out.println("*** Ingresa un DNI para buscar en la lista de clientes ***");
        String dni = scanner.next();

        if (listaClientes.stream().map(cliente -> cliente.getDni().equals(dni)).count() > 0){
            Cliente clienteBuscado = listaClientes.stream().filter(cliente -> cliente.getDni().equals(dni)).findFirst().get();
            System.out.println(clienteBuscado);
        }else{
            System.out.println("Cliente no encontrado");
        }*/


        //*********************************************************//

        ClienteCrud cliImp = new ClienteCrud();
        FacturaCrud factImp = new FacturaCrud();
        ItemCrud itImp = new ItemCrud();

        //creamos 3 clientes
        Cliente cli1 = new Cliente("12365458", "Luisina", "de Paula");
        Cliente cli2 = new Cliente("65987456", "Zlatan", "Ibrahimovic");
        Cliente cli3 = new Cliente("11254789", "Avril", "Lavigne");

        cliImp.save(cli1); //guardar un cliente
        cliImp.mostrarPantalla(); //mostrando todos los clientes

        //búsqueda del cliente
      /*  Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese el dni a buscar");
        Long dniBuscado = teclado.nextLong();
        cliImp.buscar(dniBuscado);*/


        //borrado del cliente
        /*System.out.println("Ingrese el dni a buscar para eliminar");
        Long dniBorrado = teclado.nextLong();
        cliImp.eliminar(dniBorrado);*/

        //crear Intems
        ItemCrud itemsFacturaUno = new ItemCrud();
        Item item1 = new Item("A1","leche", 2, 3500.00);
        Item item2 = new Item("A1","Huevos", 60, 500.00);
        Item item3 = new Item("A1","Pan", 5, 1000.00);
        itemsFacturaUno.save(item1);
        itemsFacturaUno.save(item2);
        itemsFacturaUno.save(item3);

        FacturaCrud facturaCrudUno = new FacturaCrud();
        Long codigoFacturaUno = 646546L;
        Factura factura1 = new Factura(cli1,itemsFacturaUno.traerTodos(),codigoFacturaUno);
        facturaCrudUno.save(factura1);
        factura1.getTotalCompra();
        facturaCrudUno.mostrarPantalla();


    }
}

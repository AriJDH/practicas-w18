import model.Cliente;
import model.Factura;
import model.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("PARTE 1");

        //Creo una lista con Clientes
        List<Cliente> clientes = new ArrayList<>();
        Cliente cliente1 = new Cliente("1234","Sofia","Monasterio");
        Cliente cliente2 = new Cliente("456","Pablo","Cuezzo");
        Cliente cliente3 = new Cliente("789","Humita","Cuezzo");

        clientes.add(cliente1);
        clientes.add(cliente2);
        clientes.add(cliente3);

        System.out.println("------recorrer la lista de clientes-----");
        //recorrer la lista de clientes
        clientes.stream().forEach(System.out::println);

        System.out.println("------eliminar un cliente de la lista y mostrar los restantes-----");
        //eliminar un cliente de la lista y mostrar los restantes
        Scanner scanner = new Scanner(System.in);
        String dniAEliminar = scanner.nextLine();
        System.out.println("Está por eliminar el DNI: "+dniAEliminar);

        Cliente clienteAEliminar;
        for (Cliente c: clientes) {
            if (c.getDni().equals(dniAEliminar)){
                clientes.remove(c);
                System.out.println("Cliente eliminado exitosamente");
                clientes.stream().forEach(System.out::println);
            }else {
                System.out.println("No se encontró el cliente");
            }
            break;
        }



        System.out.println("------ingresar dni por teclado para buscar un cliente------");
        //buscar un cliente por teclado
        String dniIngresado = scanner.nextLine();
        System.out.println(dniIngresado);

        clientes.stream()
                .filter(cliente -> cliente.getDni().equals(dniIngresado))
                .forEach(System.out::println);




        System.out.println("--------PARTE 2---------");

        List<Item> itemsList = new ArrayList<>();
        Item arroz = new Item("A1","Arroz",1,139.00);
        Item fideos = new Item("F1","Fideos",2,89.99);
        Item coca = new Item("C1","Coca Cola", 1, 140.70);

        itemsList.add(arroz);
        itemsList.add(fideos);
        itemsList.add(coca);


        Double costoItemsList=0.0;
        for (Item i: itemsList ) {
            Double costo =i.getCostoUnitario();
            costoItemsList = costoItemsList + costo;
        }
        System.out.println(costoItemsList);

        Factura factura1 = new Factura(cliente1,itemsList,costoItemsList);
        System.out.println(factura1);


        List<Factura> facturas = new ArrayList<>();

        for (Cliente c : clientes) {
            if (c.equals(factura1.getCliente())){
                facturas.add(factura1);
                System.out.println("Factura emitida correctamente. El Cliente ya se encontraba en nuestra base de datos");
            }else{
                System.out.println("El cliente no se encuentra en nuestra base de datos");
                clientes.add(c);
                facturas.add(factura1);
                System.out.println("Factura emitida correctamente. El Cliente se agregó correctamente a nuestra base de datos");
            }
            break;
        }







    }


}
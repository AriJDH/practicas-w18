package clase4_a_EjerciciosIntegrador.Ej3_Supermercado.repository;

import clase4_a_EjerciciosIntegrador.Ej3_Supermercado.model.Factura;
import clase4_a_EjerciciosIntegrador.Ej3_Supermercado.model.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class ItemImp implements CRUDRepository<Item>{

    private Scanner teclado = new Scanner(System.in);
    List<Item> listItems = new ArrayList<>();
    @Override
    public void nuevo(Item item) {
        listItems.add(item);
    }

    @Override
    public void mostrarTodos() {
        listItems.stream().forEach(System.out::println);
    }

    @Override
    public void eliminar(Item item) {
        listItems.remove(item);
    }

    @Override
    public void eliminar() {

    }

    @Override
    public Item nuevo() {
        String codigo, nombre;
        int cantComprada;
        double precioUnitario;
        System.out.println("--------------------------------------------------------------------");
        System.out.println("Producto");
        System.out.println("--------------------------------------------------------------------");
        System.out.print("Código: ");
        codigo = teclado.nextLine();
        System.out.print("Nombre: ");
        nombre = teclado.nextLine();
        System.out.print("Cantidad comprada: ");
        cantComprada = teclado.nextInt();
        teclado.nextLine();
        System.out.print("Precio Unitario: ");
        precioUnitario = teclado.nextDouble();
        teclado.nextLine();
        Item item = new Item(codigo, nombre, cantComprada, precioUnitario);
        nuevo(item);
        return item;
    }

    @Override
    public void mostrarUno() {
        String codigo;
        System.out.println("--------------------------------------------------------------------");
        System.out.printf("Ingrese el código del item a mostrar: ");
        codigo = teclado.nextLine();
        System.out.println("--------------------------------------------------------------------");
        Optional<Item> item = buscar(codigo);
        if (item.isPresent()){
            System.out.println(item.get());
        }else{
            System.out.println("No se encontró el item con código " + codigo);
        }
        System.out.println("\nPresione una tecla para continuar...");
        teclado.nextLine();
    }

    @Override
    public Optional<Item> buscar(String s) {
        return listItems.stream().filter(c-> c.getCodigo().equals(s)).findFirst();
    }
}

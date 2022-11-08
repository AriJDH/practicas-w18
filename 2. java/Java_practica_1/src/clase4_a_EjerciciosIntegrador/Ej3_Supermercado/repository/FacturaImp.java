package clase4_a_EjerciciosIntegrador.Ej3_Supermercado.repository;

import clase4_a_EjerciciosIntegrador.Ej3_Supermercado.model.Cliente;
import clase4_a_EjerciciosIntegrador.Ej3_Supermercado.model.Factura;
import clase4_a_EjerciciosIntegrador.Ej3_Supermercado.model.Item;

import java.util.*;

public class FacturaImp implements CRUDRepository<Factura> {

    private Scanner teclado = new Scanner(System.in);
    List<Factura> listFacturas = new ArrayList<>();

    ItemImp itemIMP = new ItemImp();
    @Override
    public void nuevo(Factura factura) {
        listFacturas.add(factura);
    }

    @Override
    public void mostrarTodos() {
        System.out.println("--------------------------------------------------------------------");
        System.out.println("Listado de facturas");
        System.out.println("--------------------------------------------------------------------");
        listFacturas.stream().forEach(System.out::println);
        System.out.println("\nPresione una tecla para continuar...");
        teclado.nextLine();
    }

    @Override
    public void eliminar(Factura factura) {
        listFacturas.remove(factura);
    }

    @Override
    public Factura nuevoConMenu() {
        return null;
    }

    public void nuevoConDni(Cliente cliente) {
        System.out.println("--------------------------------------------------------------------");
        System.out.println("Nueva factura");
        System.out.println("--------------------------------------------------------------------");
        List<Item> listaItems = new ArrayList<>();
        char opcion = 'N';
        do {
            listaItems.add(itemIMP.nuevoConMenu());
            System.out.println("--------------------------------------------------------------------");
            System.out.print("Desea registrar otro producto a la factura? (S/N): ");
            opcion = teclado.nextLine().toUpperCase().charAt(0);
        } while(opcion == 'S');
        Factura factura = new Factura(String.valueOf(listFacturas.size()+1),cliente, listaItems);
        listFacturas.add(factura);
        System.out.println("--------------------------------------------------------------------");
        System.out.println("El monto total de la factura es $" + factura.getTotalCompra());
        System.out.println("\nPresione una tecla para continuar...");
        teclado.nextLine();
    }

    @Override
    public void mostrarUno() {
        String codigo;
        System.out.println("--------------------------------------------------------------------");
        System.out.printf("Ingrese el código de la factura a mostrar: ");
        codigo = teclado.nextLine();
        System.out.println("--------------------------------------------------------------------");
        Optional<Factura> factura = buscar(codigo);
        if (factura.isPresent()){
            System.out.println(factura.get());
        }else{
            System.out.println("No se encontró la factura con código " + codigo);
        }
        System.out.println("\nPresione una tecla para continuar...");
        teclado.nextLine();
    }

    @Override
    public Optional<Factura> buscar(String s) {
        return listFacturas.stream().filter(c-> c.getCodigo().equals(s)).findFirst();
    }
}

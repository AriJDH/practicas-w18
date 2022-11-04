import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<Cliente> dbCliente = new ArrayList<>();
        ArrayList<Producto> productos = new ArrayList<>();

        Cliente c1 = new Cliente("11111111", "Lucas", "Padularrosa");
        Cliente c2 = new Cliente("22222222", "Pablo", "Perez");
        Cliente c3 = new Cliente("33333333", "Maxi", "Rodriguez");

        dbCliente.add(c1);
        dbCliente.add(c2);
        dbCliente.add(c3);

        Producto manzanas = new Producto(1, "manzanas", 5, 10);
        Producto peras = new Producto(2, "peras", 3, 8.5);
        Producto uvas = new Producto(3, "uvas", 20, 6.3);

        productos.add(manzanas);
        productos.add(peras);
        productos.add(uvas);

        Factura f1 = new Factura(c1, productos);

        // Mostrar clientes
        dbCliente.stream()
                .forEach(cliente -> System.out.println(cliente));

        // Eliminar un cliente
        dbCliente.remove(2);
        System.out.println("Lista clientes actualizada");
        dbCliente.stream()
                .forEach(cliente -> System.out.println(cliente));


        Scanner s = new Scanner(System.in);
        System.out.println("Busque un usuario por su numero de DNI: ");
        String dni = s.nextLine();

        /*for (Cliente c : dbCliente){
            if(c.getDni().equals(dni)){
                System.out.println(c);
                return;
            }
            }
        */
        // Parte 2
        f1.crearFactura(f1, dbCliente);

        System.out.println(f1);
    }
}
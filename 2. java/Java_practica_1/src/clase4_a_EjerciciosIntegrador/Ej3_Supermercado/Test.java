package clase4_a_EjerciciosIntegrador.Ej3_Supermercado;

import clase4_a_EjerciciosIntegrador.Ej3_Supermercado.model.Cliente;
import clase4_a_EjerciciosIntegrador.Ej3_Supermercado.repository.ClienteImp;
import clase4_a_EjerciciosIntegrador.Ej3_Supermercado.repository.FacturaImp;

import java.util.*;

public class Test {

    private static final Scanner teclado = new Scanner(System.in);
    private static ClienteImp cliIMP = new ClienteImp();
    private static FacturaImp facIMP = new FacturaImp();

    public static void main(String[] args) {
        char opcion='0';
        do{
            System.out.println("--------------------------------------------------------------------");
            System.out.println("Supermercado - Ingrese su opción: ");
            System.out.println("--------------------------------------------------------------------");
            System.out.println("1 - Nuevo cliente");
            System.out.println("2 - Mostrar todos los cientes");
            System.out.println("3 - Eliminar cliente x DNI");
            System.out.println("4 - Mostrar cliente x DNI");
            System.out.println("5 - Nueva Factura");
            System.out.println("6 - Mostrar factura X Código");
            System.out.println("\n0 - Salir");
            System.out.println("--------------------------------------------------------------------");
            opcion = teclado.nextLine().charAt(0);
            switch (opcion){
                case '1': cliIMP.nuevoConMenu();
                    break;
                case '2': cliIMP.mostrarTodos();
                    break;
                case '3': cliIMP.eliminarConMenu();
                    break;
                case '4': cliIMP.mostrarUno();
                    break;
                case '5': nuevaFactura();
                    break;
                case '6': facIMP.mostrarUno();
                    break;
                case '0': System.out.println("\nSaliendo...");
                    break;
            }
        }while (opcion != '0');
        teclado.close();
    }
    public static void nuevaFactura(){
        System.out.println("--------------------------------------------------------------------");
        System.out.print("Ingrese el DNI del cliente: ");
        String dni = teclado.nextLine();
        Optional<Cliente> cliente = cliIMP.buscar(dni);
        if (!cliente.isPresent()) {
            System.out.println("--------------------------------------------------------------------");
            System.out.println("El cliente no existe, se procede a crearlo...");
            System.out.println("--------------------------------------------------------------------");
            facIMP.nuevoConDni(cliIMP.nuevoConMenu());
        } else {
            facIMP.nuevoConDni(cliente.get());
        }
    }


}

package clase4_a_EjerciciosIntegrador.Ej3_Supermercado;

import clase4_a_EjerciciosIntegrador.Ej3_Supermercado.repository.ClienteImp;
import clase4_a_EjerciciosIntegrador.Ej3_Supermercado.repository.FacturaImp;

import java.util.*;

public class Test {

    public static void main(String[] args) {
        menuSupermercado();
    }
    public static void menuSupermercado(){
        Scanner teclado = new Scanner(System.in);
        ClienteImp cliIMP = new ClienteImp();
        FacturaImp facIMP = new FacturaImp();
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
                case '5': facIMP.nuevoConMenu();
                    break;
                case '0': System.out.println("\nSaliendo...");
                    break;
            }
        }while (opcion != '0');
        teclado.close();
    }
}

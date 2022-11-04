package clase4_a_EjerciciosIntegrador.Ej3_Supermercado;

import java.util.*;

public class Test {
    public static void main(String[] args) {

        System.out.println("--------------------------------------------------------------------");
        System.out.println("Crear 3 clientes y guardarlos en una collection.");
        System.out.println("--------------------------------------------------------------------");
        Cliente client1 = new Cliente("32654133","Facundo", "Parra");
        Cliente client2 = new Cliente("33241223", "Enzo","Hoyos");
        Cliente client3 = new Cliente("23123433", "Santiago", "Godoy");
        Set<Cliente> setClientes = new HashSet<>();
        setClientes.add(client1);
        setClientes.add(client2);
        setClientes.add(client3);
        System.out.println("--------------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------------");
        System.out.println("Recorrer la collection de clientes y mostrar por pantalla los datos de cada uno de ellos.");
        System.out.println("--------------------------------------------------------------------");
        setClientes.stream().forEach(System.out::println);
        System.out.println("--------------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------------");
        System.out.println("Eliminar uno de los clientes de la lista y volver a consultar e imprimir todos los clientes restantes.");
        System.out.println("--------------------------------------------------------------------");
        setClientes.remove(client1);
        setClientes.stream().forEach(System.out::println);
        System.out.println("--------------------------------------------------------------------");
        System.out.println("Solicitar por teclado un número de dni de un cliente para buscarlo. \nEn caso de que el cliente se encuentre en la lista, mostrar sus datos, \ncaso contrario, mostrar un mensaje que informe dicha situación.");
        System.out.println("--------------------------------------------------------------------");
        Scanner teclado = new Scanner(System.in);
        System.out.printf("Ingrese un dni para buscar el cliente: ");
        String dni = teclado.nextLine();


        Optional Cliente = setClientes.stream().filter(c-> c.getDni().equals(dni)).findFirst();
        //Cliente.isEmpty() ? System.out.println("No se encontró en DNI") : Cliente.toString();


        teclado.close();

    }
}

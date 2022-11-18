import Clases.Cliente;
import Repositorio.BaseDatos;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Cliente cliente1 = new Cliente("1", "Vanessa", "Mususue");
        Cliente cliente2 = new Cliente("2", "Camilo", "Montoya");
        Cliente cliente3 = new Cliente("3", "Natalia", "Ruíz");
        Scanner teclado = new Scanner();

        BaseDatos db = new BaseDatos();

        db.agregar(cliente1);
        db.agregar(cliente2);
        db.agregar(cliente3);

        db.mostrarTodos();
        System.out.println("---------------------------------------------------------------");

        db.eliminar(cliente2);

        db.mostrarTodos();
        System.out.println("---------------------------------------------------------------");




    }
}

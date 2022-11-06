package com.company;

import com.company.clases.Cliente;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // creación de clientes
        Cliente cliente1 = new Cliente(12365458, "Martina", "Lopez");
        Cliente cliente2 = new Cliente(12111458, "Maria", "Castro");
        Cliente cliente3 = new Cliente(12222455, "Gustavo", "Caballero");

        //guardado en colleccion
        List<Cliente> listaClientes = new ArrayList<>();
        listaClientes.add(cliente1);
        listaClientes.add(cliente2);
        listaClientes.add(cliente3);

        //muestra de elementos
        for (Cliente c : listaClientes) {
            System.out.println("DNI: " + c.getDni());
            System.out.println("Nombre: " + c.getNombre());
            System.out.println("Apellido: " + c.getApellido());
        }

        //borrado de cliente
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese dni a borrar: ");
        int dniDelete = teclado.nextInt();
        teclado.nextLine();
        Boolean delete = false;

        for (Cliente c : listaClientes) {
            if (c.getDni() == dniDelete) {
                listaClientes.remove(c);
                delete = true;
                break;
            }
        }

        if (delete == false) {
            System.out.println("No se encontro al cliente");
        } else {
            System.out.println("Cliente borrado correctamente");
        }
//Busqueda de cliente

        System.out.println("Ingrese dni a borrar: ");
        int dniBuscar = teclado.nextInt();
        teclado.nextLine();
        Boolean busqueda = false;
        for (Cliente c : listaClientes) {
            if (c.getDni() == dniBuscar) {
                System.out.println("DNI: " + c.getDni());
                System.out.println("Nombre: " + c.getNombre());
                System.out.println("Apellido: " + c.getApellido());
                busqueda = true;
                break;
            }
        }

        if (busqueda == false) {
            System.out.println("No se encontro al cliente");
        }
    }
}

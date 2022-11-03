package org.example;

import org.example.domain.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente(1, "Roberto", "Bolaños"));
        clientes.add(new Cliente(2, "Homero", "Sinso"));
        clientes.add(new Cliente(3, "Bart", "Sinso"));
        System.out.println("Clientes:");
        clientes.forEach(cli-> System.out.println(cli.toString()));
        System.out.println("Eliminamos cliente 3");
        clientes.remove(2);
        System.out.println("Clientes:");
        clientes.forEach(cli-> System.out.println(cli.toString()));

        while(true) {
            System.out.println("Ingrese el dni del cliente que quiere buscar:");
            int dniABuscar = teclado.nextInt();
            teclado.nextLine();

            Optional<Cliente> cliente = clientes.stream().filter(cli -> cli.getDni() == dniABuscar).findFirst();
            if (cliente.isPresent()) {
                System.out.println("Datos del cliente: ");
                System.out.println(cliente.get().toString());
            } else {
                System.out.println("El cliente solicitado no existe");
            }
        }
    }
}
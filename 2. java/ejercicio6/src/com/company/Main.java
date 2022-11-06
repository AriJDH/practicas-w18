package com.company;

import javax.sound.midi.Soundbank;
import java.util.*;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
	// instancia de la clase garaje con lista de vehiculos
        Garaje g1 = new Garaje();
        Vehiculo vh = new Vehiculo();
        g1.setId("garaje1");

        int cantidad = 0;
    //ingreso datos por consola
        Scanner teclado = new Scanner(System.in);
        System.out.println("------- MENU -------");
        System.out.println("Ingrese la cantidad de vehiculos para almacenar");
        cantidad = teclado.nextInt();
        teclado.nextLine(); // para comer el salto de linea

        do {
            System.out.println("Ingrese Marca : ");
            vh.setMarca(teclado.nextLine());

            System.out.println("Ingrese Modelo: ");
            vh.setModelo(teclado.nextLine());

            System.out.println("Ingrese Costo: ");
            vh.setCosto(Integer.parseInt(teclado.nextLine()));

            g1.setLisado(vh);

            cantidad = cantidad -1;
        }while (cantidad > 0);

    //muestra de datos, de forma ordenada de menor a mayor, segun el precio

        List <Vehiculo> vehiculo = Arrays.asList();

        vehiculo.stream().sorted(Comparator.comparing(Vehiculo::getCosto)).forEach(System.out::println);

    }
}

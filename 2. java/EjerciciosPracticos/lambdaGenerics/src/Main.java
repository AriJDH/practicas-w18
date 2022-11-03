import java.util.*;

public class Main {
    public static void main(String[] args)
    {
        //Creo los vehiculos

        Vehiculo v0 = new Vehiculo("Ford","Fiesta",1000);
        Vehiculo v1 = new Vehiculo("Ford","Focus",1200);
        Vehiculo v2 = new Vehiculo("Ford","Explorer",2500);
        Vehiculo v3 = new Vehiculo("Fiat","Uno",500);
        Vehiculo v4 = new Vehiculo("Fiat","Cronos",1000);
        Vehiculo v5 = new Vehiculo("Fiat","Torino",1250);
        Vehiculo v6 = new Vehiculo("Chevrolet","Aveo",1250);
        Vehiculo v7 = new Vehiculo("Chevrolet","Spin",2500);
        Vehiculo v8 = new Vehiculo("Toyota","Corola",1200);
        Vehiculo v9 = new Vehiculo("Toyota","Fortuner",3000);
        Vehiculo v10 = new Vehiculo("Renault","Logan",950);

        //Creo la lista con los vehiculos creados
        List<Vehiculo> listaVehiculos = new ArrayList<>();

        //Cargo los vehiculos a la lista
        listaVehiculos.add(v0);
        listaVehiculos.add(v1);
        listaVehiculos.add(v2);
        listaVehiculos.add(v3);
        listaVehiculos.add(v4);
        listaVehiculos.add(v5);
        listaVehiculos.add(v6);
        listaVehiculos.add(v7);
        listaVehiculos.add(v8);
        listaVehiculos.add(v9);
        listaVehiculos.add(v10);

        //Crear instancia
        Garaje garaje1 = new Garaje(1,listaVehiculos);

        //Informo orden
        System.out.println("\n ********************************** Los vehiculos ordenados segun su costo son: **********************************");

        //Lista de vehiculos por precio menor a mayor
        listaVehiculos.sort(Comparator.comparing(Vehiculo::getCosto));

        //Presento la lista ordenada
        listaVehiculos.forEach(System.out::println);

        //Informo orden
        System.out.println("\n********************************** Ordenados por Marca y Precio **********************************");

        //Ordenamos por marca y precio
        listaVehiculos.sort(Comparator.comparing(Vehiculo::getMarca)
                .thenComparing(Comparator.comparing(Vehiculo::getCosto)));
        listaVehiculos.forEach(System.out::println);

        //Informo orden
        System.out.println("\n********************************** Agrupados por precio menor a 1000 **********************************");

        //Orenda precio menores a 1000
        listaVehiculos.stream()
                .filter((v) -> v.getCosto() < 1000)
                .forEach(System.out::println);

        //Informo orden
        System.out.println("\n********************************** Agrupados por precio mayor o igual a 1000 **********************************");

        listaVehiculos.stream()
                .filter((v) -> v.getCosto() >= 1000)
                .forEach(System.out::println);

        System.out.println(" \n ********************************** Promedio total de precios **********************************");

        LongSummaryStatistics sum= listaVehiculos.stream().mapToLong((v)-> (long) v.getCosto()).summaryStatistics();
        System.out.println(((LongSummaryStatistics) sum).getAverage());


    }
}
import java.util.*;

public class main {
    public static void main(String[] args){

        //Creo instancia de la clase Vehiculo


        Vehiculo v1 = new Vehiculo("Ford", "Fiesta", 1000);
        Vehiculo v2 = new Vehiculo("Ford", "Focus", 1200);
        Vehiculo v3 = new Vehiculo("Ford", "Explorer", 2500);
        Vehiculo v4 = new Vehiculo("Fiat", "Uno", 500);
        Vehiculo v5 = new Vehiculo("Fiat", "Cronos", 1000);
        Vehiculo v6 = new Vehiculo("Fiat", "Torino", 1250);
        Vehiculo v7 = new Vehiculo("Chevrolet", "Aveo", 1250);
        Vehiculo v8 = new Vehiculo("Chevrolet", "Spin", 2500);
        Vehiculo v9 = new Vehiculo("Toyota", "Corolla", 1200);
        Vehiculo v10 = new Vehiculo("Toyota", "Fortuner", 3000);
        Vehiculo v11 = new Vehiculo("Renault", "Logan", 950);

        ArrayList<Vehiculo> vehiculos = new ArrayList<>();

        vehiculos.add(v1);
        vehiculos.add(v2);
        vehiculos.add(v3);
        vehiculos.add(v4);
        vehiculos.add(v5);
        vehiculos.add(v6);
        vehiculos.add(v7);
        vehiculos.add(v8);
        vehiculos.add(v9);
        vehiculos.add(v10);
        vehiculos.add(v11);

        Garaje garaje = new Garaje(1, vehiculos);

        //System.out.println(garaje.getVehiculos());

        //Ejercicio 3 - Obtengo lista de vechiculos ordenados por precio de menor a mayor
        List<Vehiculo> vehiculosOrdPorPrecio = Arrays.asList(v1,v2,v3,v4,v5,v6,v7,v8,v9,v10,v11);
        System.out.println("Lista de vehiculos ordenada por precio de menor a mayor: " + "\n");
        vehiculosOrdPorPrecio.stream().sorted(Comparator.comparing(Vehiculo::getCosto)).forEach(System.out::println);

        //Ejercicio 4 - Obtengo lista ordenada por marca y precio

        List<Vehiculo> vehiculosOrdPorMarcaYPrecio = Arrays.asList(v1,v2,v3,v4,v5,v6,v7,v8,v9,v10,v11);
        Comparator<Vehiculo> comparadorMultiple= Comparator.comparing(Vehiculo::getMarca).thenComparing(Comparator.comparing(Vehiculo::getCosto));
        //System.out.println("Lista de vehiculos ordenados por marca y precio: " + "\n");
        //vehiculosOrdPorMarcaYPrecio.stream().sorted(comparadorMultiple).forEach(System.out::println);

        //Ejercicio 5

        //Obtengo lista de vehiculos con precio menor a mil
        List<Vehiculo> vehiculosMenorAMil = Arrays.asList(v1,v2,v3,v4,v5,v6,v7,v8,v9,v10,v11);
        System.out.println("Lista de vechiculos con precio menor a mil: " + "\n");
        vehiculosMenorAMil.stream().filter(vehiculo -> vehiculo.getCosto() < 1000).forEach(System.out::println);

        //Obtengo lista de vehiculos con precios mayor o igual a mil
        List<Vehiculo> vehiculosMayorOIgualAMil = Arrays.asList(v1,v2,v3,v4,v5,v6,v7,v8,v9,v10,v11);
        System.out.println("Lista de vechiculos con precio mayor o igual a mil: " + "\n");
        vehiculosMayorOIgualAMil.stream().filter(vehiculo -> vehiculo.getCosto() >= 1000).forEach(System.out::println);

        //Obtengo promedio total de los precios de todos los vehiculos
        List<Vehiculo> promedioPrecios = Arrays.asList(v1,v2,v3,v4,v5,v6,v7,v8,v9,v10,v11);
        Double promedio = promedioPrecios.stream().mapToDouble(vehiculo -> vehiculo.getCosto()).average().getAsDouble();
        System.out.println("El promedio de los precios de los vehiculos es: " + promedio);

    }
}

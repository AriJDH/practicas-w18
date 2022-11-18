import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Vehiculo> vehiculos = new ArrayList<>();
        Vehiculo vehiculo1 = new Vehiculo("Ford","Fiesta",1000);
        Vehiculo vehiculo2 = new Vehiculo("Ford","Focus",1200);
        Vehiculo vehiculo3 = new Vehiculo("Ford","Explorer",2500);
        Vehiculo vehiculo4 = new Vehiculo("Fiat","Uno",500);
        Vehiculo vehiculo5 = new Vehiculo("Fiat","Cronos",1000);
        Vehiculo vehiculo6 = new Vehiculo("Fiat","Torino",1250);
        Vehiculo vehiculo7 = new Vehiculo("Chevrolet","Aveo",1250);
        Vehiculo vehiculo8 = new Vehiculo("Chevrolet","Spin",2500);
        Vehiculo vehiculo9 = new Vehiculo("Toyota","Corolla",1200);
        Vehiculo vehiculo10 = new Vehiculo("Toyota","Fortuner",3000);
        Vehiculo vehiculo11 = new Vehiculo("Renault","Logan",950);

        vehiculos.add(vehiculo1);
        vehiculos.add(vehiculo2);
        vehiculos.add(vehiculo3);
        vehiculos.add(vehiculo4);
        vehiculos.add(vehiculo5);
        vehiculos.add(vehiculo6);
        vehiculos.add(vehiculo7);
        vehiculos.add(vehiculo8);
        vehiculos.add(vehiculo9);
        vehiculos.add(vehiculo10);
        vehiculos.add(vehiculo11);

        Garage garage = new Garage(1,vehiculos);
        //Ejercicio 3
        System.out.println("-------------------------------------------------------------------");
        System.out.println("LISTA DE VEHÍCULOS ORDENADA POR PRECIO EN ORDEN DESCENDENTE");
        List<Vehiculo> lista1=garage.getVehiculos()
                .stream()
                .sorted(Comparator.comparing(Vehiculo::getCosto)
                        .reversed())
                .collect(Collectors.toList());
        lista1.forEach(System.out::println);
        System.out.println("-------------------------------------------------------------------");
        System.out.println("LISTA DE VEHÍCULOS ORDENADA POR PRECIO EN ORDEN ASCENDENTE");
        List<Vehiculo> lista2=garage.getVehiculos()
                .stream()
                .sorted(Comparator.comparing(Vehiculo::getCosto))
                .collect(Collectors.toList());
        lista2.forEach(System.out::println);
        System.out.println("-------------------------------------------------------------------");
        System.out.println("LISTA DE VEHÍCULOS ORDENADA POR PRECIO UTILIZANDO compareTo()");
        List<Vehiculo> lista3=garage.getVehiculos()
                .stream()
                .sorted((x,y)-> x.getCosto().compareTo(y.getCosto()))
                .collect(Collectors.toList());
        lista3.forEach(System.out::println);
        System.out.println("-------------------------------------------------------------------");
        //Ejercicio 4
        System.out.println("LISTA DE VEHÍCULOS ORDENADA POR MARCA Y A SU VEZ POR PRECIO");
        List<Vehiculo> lista4= garage.getVehiculos()
                .stream()
                .sorted(Comparator.comparing(Vehiculo::getMarca)
                        .thenComparing(Vehiculo::getCosto))
                .collect(Collectors.toList());
        lista4.forEach(System.out::println);
        System.out.println("-------------------------------------------------------------------");
        //Ejercicio 5
        System.out.println("LISTA DE VEHÍCULOS CON PRECIO NO MAYOR A 1000");
        List<Vehiculo> lista5=garage.getVehiculos()
                .stream()
                .filter(vehiculo -> vehiculo.getCosto() <= 1000)
                .collect(Collectors.toList());
        lista5.forEach(System.out::println);
        System.out.println("-------------------------------------------------------------------");
        System.out.println("LISTA DE VEHÍCULOS CON PRECIO MAYOR O IGUAL A 1000");
        List<Vehiculo> lista6=garage.getVehiculos()
                .stream()
                .filter(vehiculo -> vehiculo.getCosto() >= 1000)
                .collect(Collectors.toList());
        lista6.forEach(System.out::println);
        System.out.println("-------------------------------------------------------------------");
        System.out.println("PROMEDIO TOTAL DE PRECIOS DE TODA LA LISTA DE VEHÍCULOS");
        garage.getVehiculos()
                .stream()
                .mapToDouble(vehiculo -> vehiculo.getCosto())
                .average()
                .stream()
                .forEach(System.out::println);
        Double promedio = garage.getVehiculos()
                .stream()
                .collect(Collectors.averagingDouble(Vehiculo::getCosto));
        System.out.printf("Promedio utilizando .averagingDouble: %.2f", promedio );
    }
}
package Ejercicio1;
import java.util.Arrays;
import java.util.Comparator;


public class Test {
    public static void main(String[] args) {
        Vehiculo v1 = new Vehiculo("Ford", "Fiesta", 1000);
        Vehiculo v2 = new Vehiculo("Ford", "Focus", 1200);
        Vehiculo v3 = new Vehiculo("Ford", "Explorer", 2500);
        Vehiculo v4 = new Vehiculo("Fiat", "Uno", 500);
        Vehiculo v5 = new Vehiculo("Fiat", "Cronos", 1000);
        Vehiculo v6 = new Vehiculo("Fiat", "Torino", 1250);
        Vehiculo v7 = new Vehiculo("Chevrolet", "Aveo", 1250);
        Vehiculo v8 = new Vehiculo("Chevrolet", "Spin", 2500);
        Vehiculo v9 = new Vehiculo("Toyota", "Corola", 1200);
        Vehiculo v10 = new Vehiculo("Toyota", "Fortuner", 3000);
        Vehiculo v11 = new Vehiculo("Renault", "Logan", 950);

        Garage garage = new Garage(1, Arrays.asList(v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11));

//        garage.getVehiculos().stream()
//                .sorted((x,y) -> x.getCosto().compareTo(y.getCosto()))
//                .forEach(System.out::println);
//
//        garage.getVehiculos().stream()
//                .sorted((x,y) -> x.getCosto().compareTo(y.getCosto()))
//                .sorted((x,y) -> x.getMarca().compareToIgnoreCase(y.getMarca()))
//                .forEach(System.out::println);
//
//        garage.getVehiculos().stream()
//                .sorted(Comparator.comparing(Vehiculo::getCosto))
//                .sorted((x,y) -> x.getMarca().compareToIgnoreCase(y.getMarca()))
//                .forEach(System.out::println);


//                garage.getVehiculos()
//                .stream()
//                .sorted(Comparator.comparing(Vehiculo::getMarca)
//                        .thenComparing(Vehiculo::getCosto))
//                        .forEach(System.out::println);

        System.out.println("Muestra vehiculos con precio <= 1000");
        garage.getVehiculos().stream()
                .filter(p->(p.getCosto()<=1000))
                .forEach(System.out::println);

        System.out.println("Muestra vehiculos con precio >= 1000");
        garage.getVehiculos().stream()
                .filter(p->(p.getCosto()>=1000))
                .forEach(System.out::println);

        System.out.println("Mostrar promedio de precios");
        Double promedio = (garage.getVehiculos()
                .stream()
                .mapToDouble(v -> v.getCosto())
                .sum()) / garage.getVehiculos().size();
        System.out.println(promedio);

        System.out.println("Mostrar promedio2 de precios");
        Double promedio2 = (garage.getVehiculos()
                .stream()
                .mapToDouble(v -> v.getCosto()).average()).getAsDouble();
        System.out.printf("%.2f", promedio2);

        //Double.compare(x.getCosto(), y.getCosto()) para hacer la comparacion con el primitivo
    }
}

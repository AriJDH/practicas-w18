import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        String marcas[] = {"Ford", "Ford", "Ford",
                "Fiat", "Fiat", "Fiat",
                "Chevrolet", "Chevrolet", "Toyota", "Toyota", "Renault"};

        String modelos[] = {"Fiesta", "Focus", "Explorer",
                "Uno", "Cronos", "Torino",
                "Aveo", "Spin", "Corola", "Fortuner", "Logan"};

        double precios[] = {1000, 1200, 2500, 500, 1000, 1250, 1250, 2500, 1200, 3000, 950};

        List<Vehiculo> vehiculos = IntStream
                .range(0, marcas.length)
                .mapToObj(i -> new Vehiculo(modelos[i], marcas[i], precios[i]))
                .collect(Collectors.toList());

        Garage garage = new Garage(1, vehiculos);
        System.out.println("Vehiculos ordenados por precio: ");
        System.out.println();
        vehiculos.stream()
                .sorted(Comparator.comparingDouble(Vehiculo::getCosto))
                .collect(Collectors.toList())
                .forEach(System.out::println);
        System.out.println();

        System.out.println("Vehiculos ordenados por precio y marca: ");
        System.out.println();
        vehiculos.stream()
                .sorted((x,y) -> x.getMarca().compareToIgnoreCase(y.getMarca()))
                .sorted(Comparator.comparingDouble(Vehiculo::getCosto))
                .forEach(System.out::println);
        System.out.println();

        /*
        vehiculos.sort(Comparator.comparing(Vehiculo::getCosto));
        vehiculos.forEach(System.out::println);

        vehiculos.sort(Comparator.comparing(Vehiculo::getMarca))
                .thenComparing(Comparator.comparing(Vehiculo::getCosto));
        vehiculos.forEach(System.out::println);
        */

        List<Vehiculo> noMayoresA1000 = vehiculos.stream().filter(v -> v.getCosto() <= 1000).collect(Collectors.toList());
        List<Vehiculo> mayoresIgualesA1000 = vehiculos.stream().filter(v -> v.getCosto() >= 1000).collect(Collectors.toList());
        System.out.println("No mayores a 1000: ");
        System.out.println(noMayoresA1000);
        System.out.println();
        System.out.println("Mayores o iguales a 1000: ");
        System.out.println(mayoresIgualesA1000);
        System.out.println();
        System.out.println("Promedio: ");
        System.out.println(vehiculos.stream().mapToDouble(v -> v.getCosto()).average());


    }
}

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Garage {
    Comparator<Vehiculo> compareByBrand = Comparator
            .comparing(Vehiculo::getMarca)
            .thenComparing(Vehiculo::getCosto);

    List<Vehiculo> garage = new ArrayList<>();

    public void guardarVehiculo (Vehiculo v) {
        garage.add(v);
    }

    public void ordenadosPorPrecio(){
        garage.stream()
                .sorted(Comparator.comparing(vehiculo -> vehiculo.getCosto()))
                .forEach(vehiculo -> System.out.println(vehiculo));
    }

    public void ordenadosPorMarcaYPrecio() {
        garage.stream()
                .sorted(compareByBrand)
                .forEach(vehiculo -> System.out.println(vehiculo));
    }

    public void preciosOrdenados(){
        System.out.println("Costo menor que mil");
       garage.stream()
               .filter(vehiculo -> vehiculo.getCosto() < 1000)
               .forEach(menores -> System.out.println(menores));

        System.out.println("Costo mayor que mil");
        garage.stream()
                .filter(vehiculo -> vehiculo.getCosto() > 1000)
                .forEach(menores -> System.out.println(menores));

        double averge = garage.stream()
                .mapToDouble(vehiculo -> vehiculo.getCosto())
                .average()
                .orElse(0);

        System.out.println("Promedio: " + averge);
    }

}

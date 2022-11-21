import java.util.*;
import java.util.stream.Collectors;

// Contructores
public class Garage {
    protected Integer id;
    protected List<Vehiculo> vehicles;

    public Garage(Integer id, ArrayList<Vehiculo> vehiculos) {
        this.id = id;
        this.vehicles = vehiculos;
    }

    public Garage(Integer id) {
        this.id = id;
        this.vehicles = new ArrayList<Vehiculo>();
    }

 // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Vehiculo> getVehiculo() {
        return vehicles;
    }

    public void setVehiculo(ArrayList<Vehiculo> vehiculos)
    {
        this.vehicles = vehiculos;
    }


// Metodos propios
    public void agregarVehiculos(Vehiculo... vehiculos){
        for (Vehiculo v: vehiculos) {
            this.vehicles.add(v);
        }
    }

    public void imprimirVehiculosOrdenadoPorPrecio(){
        System.out.println("************** VEHICULOS PRECIO ASCENDENTE *************************");

        List≤Vehiculo> listaOrdenada = vehicles.stream()
                .sorted(Comparator.comparing(Vehiculo::getCosto))
                .collect(Collectors.toList());
        System.out.println(listaOrdenada);

        // Opcion 2:
        /* vehicles.stream()
                .sorted((x, y) -> x.getCosto().compareTo( y.getCosto()))
                .forEach(System.out::println); */

        // Opcion 3:
        /* Collections.sort(vehicles, (v1, v2) -> v1.getCosto().compareTo(v2.getCosto()));
         vehicles.forEach(System.out::println); //esta es una forma de imprimir elemento a elemento y no como lista*/

        System.out.println("*************************************************");

    }

    // Ejercicio 4
   public void imprimirVehicOrdenadosPorMarcaYPrecio(){
        System.out.println("*****************VEHICULOS ORDENADOS MARCA Y PRECIO***********************");

        vehicles.stream().sorted(Comparator.comparing(Vehiculo::getMarca)
                .thenComparing(Vehiculo::getCosto))
                .collect(Collectors.toList());

        vehicles.forEach(System.out::println);

        // Opcion 2:

        /* vehiculos.stream()
                .sorted((x, y) -> x.getCosto().compareTo( y.getCosto()))
                .sorted((x, y) -> x.getMarca().compareTo( y.getMarca()))
                .forEach(System.out::println); */

        System.out.println("**********************************************************************************************");

    }

    public void imprimirVehicConPrecioMenorOIgualA1000(){
        System.out.println("****************************IMPRIMIR VEHICULOS PRECIO MENOS IGUAL A 1000****************************");

        //vehicles.stream().filter()

        /* vehiculos.stream()
                .filter(v -> v.getCosto() <= 1000)
                .sorted((x, y) -> x.getCosto().compareTo( y.getCosto()))
                .forEach(System.out::println); */
        System.out.println("****************************************************************************************************");

    }

    public void imprimirVehiculosConPrecioMayorIgualA1000(){
        System.out.println("****************************IMPRIMIR VEHICULOS PRECIO MAYOR IGUAL A 1000****************************");

        vehicles.stream()
                .filter(v -> v.getCosto() >= 1000)
                .sorted((x, y) -> x.getCosto().compareTo( y.getCosto()))
                .forEach(System.out::println);
        System.out.println("****************************************************************************************************");

    }

    public void imprimirCostoPromedioVehiculos(){
        System.out.println("****************************IMPRIMIR VEHICULOS PRECIO PROMEDIO**************************************");

        OptionalDouble totalCosto = vehicles.stream().mapToDouble(v -> v.getCosto()).average();
        System.out.println("PRECIO PROMEDIO: $"+totalCosto.getAsDouble());
        System.out.println("****************************************************************************************************");

    }
}

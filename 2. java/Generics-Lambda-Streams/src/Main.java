import Ejercicio1Vehiculos.Clases.Garage;
import Ejercicio1Vehiculos.Clases.Vehiculo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        /*Ejercicio 2
        Haz una clase Main con el método main para representar un escenario donde se crea una instancia de la
        clase garaje con una lista de vehículos según la tabla.
         */

        ArrayList<Vehiculo> listaVehiculos = new ArrayList<>();

        listaVehiculos.add(new Vehiculo("Ford", "Fiesta", 1000.00));
        listaVehiculos.add(new Vehiculo("Ford", "Focus", 1200.00));
        listaVehiculos.add(new Vehiculo("Ford", "Explorer", 2500.00));
        listaVehiculos.add(new Vehiculo("Fiat", "Uno", 500.00));
        listaVehiculos.add(new Vehiculo("Fiat", "Cronos", 1000.00));
        listaVehiculos.add(new Vehiculo("Fiat", "Torino", 1250.00));
        listaVehiculos.add(new Vehiculo("Chevrolet","Aveo",1250.00));
        listaVehiculos.add(new Vehiculo("Chevrolet","Spin", 2500.00));
        listaVehiculos.add(new Vehiculo("Toyota", "Corola", 1200.00));
        listaVehiculos.add(new Vehiculo("Toyota", "Fortuner", 3000.00));
        listaVehiculos.add(new Vehiculo("Renault", "Logan", 950.00));

        Garage garage1= new Garage(1, listaVehiculos);

        System.out.println(garage1.toString());

        /*Ejercicio 3
        Haciendo uso del método sort en la lista de Vehículos con expresiones lambda, obtén una lista de vehículos
        ordenados por precio de menor a mayor, imprime por pantalla el resultado.
         */

        List<Vehiculo> vehiculosPorCosto= garage1.getListaVehiculos().stream().sorted((x, y)->x.getCosto().compareTo(y.getCosto())).collect(Collectors.toList());
        System.out.println("Los vehiculos por costo: ");
        vehiculosPorCosto.forEach(System.out::println);

        /*Ejercicio 4
        De la misma forma que el ejercicio anterior, imprime una lista ordenada por marca y a su vez por precio.*/

        List<Vehiculo> vehiculosPorMarca= vehiculosPorCosto.stream().sorted((x,y)-> x.getMarca().compareTo(y.getMarca())).collect(Collectors.toList());
        System.out.println("Los vehiculos por marca y costo: ");
        vehiculosPorMarca.forEach(System.out::println);

        /*Ejercicio 5
Se desea extraer una lista de vehículos con precio no mayor a 1000, luego otra con precios mayor o igual 1000 y
por último, obtén el promedio total de precios de toda la lista de vehículos.

*/

        ArrayList<Vehiculo> vehiculosMenorA1000= (ArrayList<Vehiculo>)listaVehiculos.stream().filter(vehiculo -> vehiculo.getCosto()>= 1000).collect(Collectors.toList());
        System.out.println("Los vehiculos con costo menor a 1000 son: ");
        vehiculosMenorA1000.forEach(System.out::println);

        Double promedio= listaVehiculos.stream().mapToDouble(Vehiculo::getCosto).average().getAsDouble();
        System.out.println("El promedio de costo de todos los vehiculos es: "+ promedio);
    }
}
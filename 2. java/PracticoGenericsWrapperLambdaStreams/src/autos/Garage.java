package autos;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

public class Garage {
    private int id;
    private List<Vehiculo> vehiculos;

    public Garage(int id) {
        this.id = id;
        this.vehiculos = new ArrayList<Vehiculo>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public void agregarVehiculos(Vehiculo... vehiculos){
        for (Vehiculo v: vehiculos) {
            this.vehiculos.add(v);
        }
    }

    public void imprimirVehiculosOrdenadosPorPrecioAscendente(){
        System.out.println("****************************IMPRIMIR VEHICULOS PRECIO ASCENDENTE************************************");

        vehiculos.stream()
                .sorted((x, y) -> x.getCosto().compareTo( y.getCosto()))
                .forEach(System.out::println);

        System.out.println("****************************************************************************************************");

    }

    public void imprimirVehiculosOrdenadosPorMarcaYPrecio(){
        System.out.println("****************************IMPRIMIR VEHICULOS ORDENADOS MARCA-PRECIO*******************************");

        vehiculos.stream()
                .sorted((x, y) -> x.getCosto().compareTo( y.getCosto()))
                .sorted((x, y) -> x.getMarca().compareTo( y.getMarca()))
                .forEach(System.out::println);
        System.out.println("****************************************************************************************************");

    }

    public void imprimirVehiculosConPrecioMenorIgualA1000(){
        System.out.println("****************************IMPRIMIR VEHICULOS PRECIO MENOS IGUAL A 1000****************************");

        vehiculos.stream()
                .filter(v -> v.getCosto() <= 1000)
                .sorted((x, y) -> x.getCosto().compareTo( y.getCosto()))
                .forEach(System.out::println);
        System.out.println("****************************************************************************************************");

    }

    public void imprimirVehiculosConPrecioMayorIgualA1000(){
        System.out.println("****************************IMPRIMIR VEHICULOS PRECIO MAYOR IGUAL A 1000****************************");

        vehiculos.stream()
                .filter(v -> v.getCosto() >= 1000)
                .sorted((x, y) -> x.getCosto().compareTo( y.getCosto()))
                .forEach(System.out::println);
        System.out.println("****************************************************************************************************");

    }

    public void imprimirCostoPromedioVehiculos(){
        System.out.println("****************************IMPRIMIR VEHICULOS PRECIO PROMEDIO**************************************");

        OptionalDouble totalCosto = vehiculos.stream().mapToDouble(v -> v.getCosto()).average();
        System.out.println("PRECIO PROMEDIO: $"+totalCosto.getAsDouble());
        System.out.println("****************************************************************************************************");

    }
}

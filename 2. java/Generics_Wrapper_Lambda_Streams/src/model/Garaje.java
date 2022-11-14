package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Garaje {
  private int id;
  private List<Vehiculo> vehiculos;

  public Garaje(int id) {
    this.id = id;
    this.vehiculos = new ArrayList<Vehiculo>();
  }

  public Garaje(int id, List<Vehiculo> vehiculos) {
    this.id = id;
    this.vehiculos = vehiculos;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void addVehiculo(Vehiculo vehiculo) {
    this.vehiculos.add(vehiculo);
  }

  public void setVehiculos(List<Vehiculo> vehiculos) {
    this.vehiculos = vehiculos;
  }

  public int getId() {
    return id;
  }

  public List<Vehiculo> getVehiculos() {
    return vehiculos;
  }

  public void vehiculosOrdenarDeMenorPrecio() {
    // @@
    // Ejercicio 3 -> Using sort
    // garaje.getVehiculos().sort(Comparator.comparing(Vehiculo::getPrecio).reversed()); // DESC
    System.out.println("-------------------------");
    System.out.println("Vehiculos de menor a mayor precio: ");
    this.vehiculos.sort(Comparator.comparing(Vehiculo::getPrecio));
    for (Vehiculo v : this.vehiculos) {
      System.out.println(
        "Modelo: " +
        v.getModelo() +
        " Marca: " +
        v.getMarca() +
        " Precio: " +
        v.getPrecio()
      );
    }
    System.out.println("-------------------------");
    // @@
  }

  public void vehiculosOrdenarPorMarcaYPrecio() {
    this.vehiculos.sort(
        Comparator
          .comparing(Vehiculo::getMarca)
          .thenComparing(Vehiculo::getPrecio)
      );
    System.out.println("-------------------------");
    System.out.println("Vehiculos por marca de menor a mayor precio: ");
    for (Vehiculo v : this.vehiculos) {
      System.out.println(
        "Modelo: " +
        v.getModelo() +
        " Marca: " +
        v.getMarca() +
        " Precio: " +
        v.getPrecio()
      );
    }

    System.out.println("-------------------------");
    // @@
  }

  public void vehiculosObtenerMenoresA(int precio) {
    // Ejercicio 5 / Secuencia de methodos
    // Menores a
    List<Vehiculo> list =
      this.vehiculos.stream()
        .filter(i -> i.getPrecio() <= precio)
        .collect(Collectors.toList());

    System.out.println("-------------------------");
    System.out.println("Vehiculos mostrar menores a: " + precio);
    for (Vehiculo v : list) {
      System.out.println(
        "Modelo: " +
        v.getModelo() +
        " Marca: " +
        v.getMarca() +
        " Precio: " +
        v.getPrecio()
      );
    }
    System.out.println("-------------------------");
    // @@
  }

  public void vehiculosObtenerMayoresA(int precio) {
    // Ejercicio 5 / Secuencia de methodos
    // mayores a
    List<Vehiculo> list =
      this.vehiculos.stream()
        .filter(i -> i.getPrecio() >= precio)
        .collect(Collectors.toList());

    System.out.println("-------------------------");
    System.out.println("Vehiculos mostrar mayores a: " + precio);
    for (Vehiculo v : list) {
      System.out.println(
        "Modelo: " +
        v.getModelo() +
        " Marca: " +
        v.getMarca() +
        " Precio: " +
        v.getPrecio()
      );
    }
    System.out.println("-------------------------");
    // @@
  }

  public void vehiculosPrecioPromedio() {
    // Promedio
    double totalPrecios =
      this.vehiculos.stream().mapToDouble(i -> i.getPrecio()).sum();

    int totalVehiculos = this.vehiculos.size();

    System.out.println("-------------------------");
    System.out.println("Vehiculos por marca de menor a mayor precio: ");
    double promedioTotal = totalPrecios / totalVehiculos;
    System.out.println("Promedio total de los Vehiculos: " + promedioTotal);
    System.out.println("-------------------------");
  }

  public static int[] burbuja(int[] array) {
    Arrays.sort(array);

    for (int i : array) {
      System.out.println(i);
    }
    return array;
  }
}
// @@
// Ejercicio 3 -> Using Collections
// Collections.sort(
//   garaje.getVehiculos(),
//   Comparator.comparing(Vehiculo::getPrecio)
// );
// Collections.reverse(garaje.getVehiculos()); // DESC
// @@

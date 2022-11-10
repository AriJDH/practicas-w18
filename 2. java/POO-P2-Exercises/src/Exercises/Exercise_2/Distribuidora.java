package Exercises.Exercise_2;

public class Distribuidora {
  Producto[] productos;

  public Distribuidora(Producto[] productos) {
    this.productos = productos;
  }

  public Producto[] getProductos() {
    return productos;
  }

  public void printResults() {
    int totalPrice = 0;
    int i = 1;
    for (Producto producto : this.productos) {
      System.out.println(
        "Nombre: " +
        producto.nombre +
        " Precio: " +
        producto.precio +
        " Cantidad de productos: " +
        i +
        " Precio final: " +
        producto.calcular(i)
      );
      i++;
      totalPrice += producto.calcular(i);
    }
    System.out.println("Precio total a vender: " + totalPrice);
  }
  // Crear una clase ejecutable llamada Distribuidora donde van a crear un array de productos,
  // imprimir el precio total al vender 5 productos de cada tipo.
  // Crear los elementos del array con los datos que quieras.

}

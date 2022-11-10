package Exercises.Exercise_2;

public class Producto {
  String nombre;
  double precio;

  public Producto(String nombre, double precio) {
    this.nombre = nombre;
    this.precio = precio;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public void setPrecio(double precio) {
    this.precio = precio;
  }

  public String getNombre() {
    return nombre;
  }

  public double getPrecio() {
    return precio;
  }

  public double calcular(int cantidadDeProductos) {
    return cantidadDeProductos * this.precio;
  }

  @Override
  public String toString() {
    // TODO Auto-generated method stub
    return super.toString();
  }
}

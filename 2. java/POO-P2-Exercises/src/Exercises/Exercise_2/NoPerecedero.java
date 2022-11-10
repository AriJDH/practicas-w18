package Exercises.Exercise_2;

public class NoPerecedero extends Producto {
  String tipo;

  public NoPerecedero(String nombre, double precio, String tipo) {
    super(nombre, precio);
    this.tipo = tipo;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }

  public String getTipo() {
    return tipo;
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

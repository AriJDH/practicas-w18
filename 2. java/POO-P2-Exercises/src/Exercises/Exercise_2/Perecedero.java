package Exercises.Exercise_2;

public class Perecedero extends Producto {
  int diasPorCaducar;

  public Perecedero(String nombre, double precio, int diasPorCaducar) {
    super(nombre, precio);
    this.diasPorCaducar = diasPorCaducar;
  }

  public void setDiasPorCaducar(int diasPorCaducar) {
    this.diasPorCaducar = diasPorCaducar;
  }

  public int getDiasPorCaducar() {
    return diasPorCaducar;
  }

  @Override
  public double calcular(int cantidadDeProductos) {
    switch (this.diasPorCaducar) {
      case 1:
        return super.calcular(cantidadDeProductos) - (super.calcular(cantidadDeProductos) * 0.40);
      case 2:
           return super.calcular(cantidadDeProductos) - (super.calcular(cantidadDeProductos) * 0.30);
      case 3:
           return super.calcular(cantidadDeProductos) - (super.calcular(cantidadDeProductos) * 0.50);
      default:
           return super.calcular(cantidadDeProductos) ;
    }
  }

  @Override
  public String toString() {
    // TODO Auto-generated method stub
    return super.toString();
  }
}

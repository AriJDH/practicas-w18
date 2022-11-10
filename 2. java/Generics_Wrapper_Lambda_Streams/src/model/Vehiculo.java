package model;

public class Vehiculo {
  private String modelo;
  private String marca;
  private double precio;

  public Vehiculo(String modelo, String marca, double precio) {
    this.modelo = modelo;
    this.marca = marca;
    this.precio = precio;
  }

  public void setModelo(String modelo) {
    this.modelo = modelo;
  }

  public void setMarca(String marca) {
    this.marca = marca;
  }

  public void setPrecio(double precio) {
    this.precio = precio;
  }

  public String getModelo() {
    return modelo;
  }

  public String getMarca() {
    return marca;
  }

  public double getPrecio() {
    return precio;
  }
}

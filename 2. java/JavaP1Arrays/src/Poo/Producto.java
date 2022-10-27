package Poo;

public class Producto {
    String nombre;
    double precio;

    public Producto(String nombre, double precio) {
        setNombre(nombre);
        setPrecio(precio);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double calcular(int cantidadDeProductos) {

        return getPrecio()*cantidadDeProductos;
    }
}

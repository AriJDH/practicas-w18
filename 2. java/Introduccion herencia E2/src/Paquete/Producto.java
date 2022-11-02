package Paquete;

public class Producto {
    protected String nombre;
    protected double precio;

    public Producto(String nombre, double precio){
        this.nombre=nombre;
        this.precio=precio;
    }

    public double calcular(int cantidadDeProductos){
        return precio * cantidadDeProductos;
    }

    //Getters y setters
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

    //El toString
    @Override
    public String toString() {
        return "Producto\n" +
                "nombre=" + nombre + '\n' +
                "precio=" + precio
                ;
    }
}

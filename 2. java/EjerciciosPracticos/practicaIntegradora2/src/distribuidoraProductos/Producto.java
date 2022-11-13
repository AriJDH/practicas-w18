package distribuidoraProductos;

public class Producto {
    //Atributos
    private String nombre;
    private double precio;

    //Getters- Setters
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

    //Constructor

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    //Método

    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + nombre + '\'' +
                ", precio=" + precio +
                '}';
    }

    //Método para calcular el precio segun cantidad de productos
    public double calcular(int cantidadDeProductos){

        double calculo= this.getPrecio() *cantidadDeProductos;

        return (calculo);
    }
}

public class Producto {

    /*********** Apartado 1 ****************/

    private String nombre;
    private double precio;

    //Constructor que recibe todos sus atributos como parametros:
    public Producto(String nombre, double precio){
        this.nombre = nombre;
        this.precio = precio;
    }

    //Metodos Setters
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    //Metodos getters
    public String getNombre(){
        return this.nombre;
    }

    public double getPrecio(){
        return this.precio;
    }

    //Sobreescritura del metodo toString()
    @Override
    public String toString(){
        return "Nombre del producto: " + this.nombre + "\n" +
                "Precio: " + this.precio + "\n";
    }

    //Metodo calcular()
    public int calcular(int cantidadDeProductos){
        return (int) (this.precio * Double.valueOf(cantidadDeProductos));
    }


}

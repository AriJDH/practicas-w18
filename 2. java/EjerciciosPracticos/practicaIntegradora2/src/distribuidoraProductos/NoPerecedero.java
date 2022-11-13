package distribuidoraProductos;

public class NoPerecedero extends Producto{
    //Atributo
    private String tipo;

    //Getters - Setters

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }


    //Constructor

    public NoPerecedero(String nombre, double precio, String tipo) {
        super(nombre, precio);
        this.tipo = tipo;
    }



    //Método toString

    @Override
    public String toString() {
        return "NoPerecedero{" +
                "tipo='" + tipo + '\'' +
                '}';
    }

    //Método para calcular el precio segun cantidad de productos
    public double calcular(int cantidadDeProductos){

        double calculo= this.getPrecio() *cantidadDeProductos;

        return (calculo);
    }
}

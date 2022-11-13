package distribuidoraProductos;

public class Perecedero extends Producto{
    //Atributos
    private int diasPorCaducar;

    //Getters- Setters
    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    //Constructor
    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    //Método

    @Override
    public String toString() {
        return "Perecedero{" +
                "diasPorCaducar=" + diasPorCaducar +
                '}';
    }

    //Método para calcular el precio segun cantidad de productos
    public double calcular(int cantidadDeProductos){

        double calculo= this.getPrecio() *cantidadDeProductos;
        double precioFinal=0;

        if (diasPorCaducar==1){
            precioFinal= calculo-(this.getPrecio()/4);
        }
        if (diasPorCaducar==2){
            precioFinal= calculo-(this.getPrecio()/3);

        }
        if (diasPorCaducar==3){

            precioFinal= calculo-(this.getPrecio()/2);
        }

        return precioFinal;
    }

}

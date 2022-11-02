package DistribuidoraProductos;

public class Perecedero extends Producto{

    private int diasPorCaducar;

    //método
    @Override
    public double calcular(int cantidadDeProducto){
        double precio = super.calcular(cantidadDeProducto);

        switch (diasPorCaducar){
            case 1: precio = precio/4;
                break;
            case 2: precio = precio/3;
                break;
            case 3: precio = precio/2;
                break;
        }

        return precio;
    }


    //constructor - getters - setters - toString
    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public String toString() {
        return "Perecedero{" +
                "diasPorCaducar=" + diasPorCaducar +
                "} " + super.toString();
    }


}

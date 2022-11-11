package Ejercicio2;

public class Perecedero extends Producto{

    private int diasPorCaducar;

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public double calcular(int cantidadDeProductos){
        super.calcular(cantidadDeProductos);
        double total = 0;
        switch (this.diasPorCaducar){
            case 1:
                total = (getPrecio() * cantidadDeProductos) / 4;
                break;
            case 2:
                total = (getPrecio() * cantidadDeProductos) / 3;
                break;
            case 3:
                total = (getPrecio() * cantidadDeProductos) / 2;
                break;
        }
        return total;
    }




}

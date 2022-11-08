package Clases;

public class Perecedero extends Producto{

    private int diasPorCaducar;

    public Perecedero(String nombre, double precio, int disPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = disPorCaducar;
    }

    public int getDisPorCaducar() {
        return diasPorCaducar;
    }

    public void setDisPorCaducar(int disPorCaducar) {
        this.diasPorCaducar = disPorCaducar;
    }

    @Override
    public String toString() {
        return "Perecedero{" +
                "nombre='" + getNombre() + '\'' +
                ", precio='" + getPrecio() + '\'' +
                ", disPorCaducar=" + diasPorCaducar +
                '}';
    }

    @Override
    public double calcular(int cantidadDeProductos) {
        super.calcular(cantidadDeProductos);
        double total = 0;
        switch (this.diasPorCaducar) {
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

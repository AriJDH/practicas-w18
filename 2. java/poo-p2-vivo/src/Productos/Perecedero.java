package Productos;

public class Perecedero extends Producto {
    int diasPorCaducar;

    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    @Override
    public double calcular(int cantidadDeProductos) {
        double nuevoPrecio = super.calcular(cantidadDeProductos);
        if (diasPorCaducar == 1) {
            nuevoPrecio/=4;
        } else if (diasPorCaducar == 2) {
            nuevoPrecio/=3;
        } else if (diasPorCaducar == 3) {
            nuevoPrecio/=2;
        }
        return nuevoPrecio;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public String toString() {
        return "Productos.Perecedero{" +
                "diasPorCaducar=" + diasPorCaducar +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                '}';
    }
}

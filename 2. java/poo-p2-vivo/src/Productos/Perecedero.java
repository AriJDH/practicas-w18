package Productos;

public class Perecedero extends Producto {
    protected int diasPorCaducar;

    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    @Override
    public double calcular(int cantidadDeProductos) {
        if (diasPorCaducar == 1) {
            return super.calcular(cantidadDeProductos)/4;
        } else if (diasPorCaducar == 2) {
            return super.calcular(cantidadDeProductos)/3;
        } else if (diasPorCaducar == 3) {
            return super.calcular(cantidadDeProductos)/2;
        }
        return super.calcular(cantidadDeProductos);
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

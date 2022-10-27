package ejercicio_poo_p2_vivo.ejercicio2;

public class Perecedero extends Producto {

    private int diasPorCaducar;

    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    public Perecedero(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public double calcular(int cantidadDeProductos) {

        double precioProducto = super.calcular(cantidadDeProductos);

        double precioFinal = 0.0;

        if (diasPorCaducar == 1) {
            precioFinal = precioProducto - (precioProducto / 4);
        }

        if (diasPorCaducar == 2) {
            precioFinal = precioProducto - (precioProducto / 3);
        }

        if (diasPorCaducar == 3) {
            precioFinal = precioProducto - (precioProducto / 2);
        }

        if (diasPorCaducar > 3) {
            precioFinal = precioProducto;
        }

        return precioFinal;
    }

    @Override
    public String toString() {
        return "Perecedero{" +
                "diasPorCaducar=" + diasPorCaducar +
                '}';
    }
}

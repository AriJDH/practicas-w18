public class Perecedero extends Producto{
    private int diasPorCaducar;

    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public String toString() {
        return "Perecedero{" +
                "diasPorCaducar=" + diasPorCaducar +
                '}';
    }

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public double calcular(int cantidadDeProductos) {
        double precioFinal;
        switch (diasPorCaducar) {
            case (1):
                precioFinal = (cantidadDeProductos * getPrecio()) / 4;
                break;
            case (2):
                precioFinal = (cantidadDeProductos * getPrecio()) / 3;
                break;
            case (3):
                precioFinal = (cantidadDeProductos * getPrecio()) / 2;
                break;
            default:
                precioFinal = cantidadDeProductos * getPrecio();
        }
        return precioFinal;
    }
}

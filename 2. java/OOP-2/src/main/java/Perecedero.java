

public class Perecedero extends Producto{

    private int diasPorCaducar;

    public Perecedero(String nombre, double precio) {
        super(nombre, precio);
    }

    @Override
    public double calcular(int cantidadDeProductos) {
        double precioTotal = this.precio * cantidadDeProductos;

        switch (this.diasPorCaducar) {
            case 1:
                return precioTotal/4;
            case 2:
                return precioTotal/3;
            case 3:
                return precioTotal/2;
            default:
                return precioTotal;
       }
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
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                '}';
    }
}
